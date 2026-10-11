package com.jsp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.entity.Exam;
import com.jsp.entity.Question;
import com.jsp.entity.User;
import com.jsp.service.ExamService;
import com.jsp.service.QuestionService;
import com.jsp.dao.ExamDao;
import com.jsp.dao.UserDao;

@Controller
public class ExamController {

	@Autowired
	private ExamService service;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ExamDao examDao;

	@Autowired
	private QuestionService questionService;

	@GetMapping("/teacher/exams")
	public String getExams(Model model) {
		model.addAttribute("exams", service.getAllExams());
		return "teacher-exams";
	}

	@GetMapping("/teacher/exams/create")
	public String getCreateExamPage() {
		return "create-exam";
	}

	@GetMapping("/teacher/dashboard")
	public String getTeacherDashboard() {
		return "teacher-dashboard";
	}
	
	@GetMapping("/teacher/exams/{examId}/questions/add")
	public String getAddQuestionPage(@PathVariable int examId, Model model) {
	    Exam exam = examDao.findById(examId)
	            .orElseThrow(() -> new IllegalArgumentException("Exam not found."));

	    model.addAttribute("exam", exam);
	    return "add-question";
	}

	@PostMapping("/teacher/exams/{examId}/questions/add")
	public String addQuestion(
	        @PathVariable int examId,
	        @RequestParam String questionText,
	        @RequestParam String optionA,
	        @RequestParam String optionB,
	        @RequestParam String optionC,
	        @RequestParam String optionD,
	        @RequestParam String correctAnswer,
	        @RequestParam int marks,
	        RedirectAttributes redirectAttributes) {

	    Exam exam = examDao.findById(examId)
	            .orElseThrow(() -> new IllegalArgumentException("Exam not found."));

	    Question question = new Question();
	    question.setQuestionText(questionText);
	    question.setOptionA(optionA);
	    question.setOptionB(optionB);
	    question.setOptionC(optionC);
	    question.setOptionD(optionD);
	    question.setCorrectAnswer(correctAnswer);
	    question.setMarks(marks);
	    question.setExam(exam);

	    questionService.saveQuestion(question);

	    redirectAttributes.addFlashAttribute("message", "Question added successfully.");

	    return "redirect:/teacher/exams/" + examId + "/questions/add";
	}

	@PostMapping("/teacher/exams/create")
	public String createExam(@RequestParam String title, @RequestParam String description, @RequestParam int duration,
			Authentication authentication, Model model) {

		User user = userDao.findByEmail(authentication.getName())
				.orElseThrow(() -> new IllegalArgumentException("User not found."));

		Exam exam = new Exam();
		exam.setTitle(title);
		exam.setDescription(description);
		exam.setDuration(duration);
		exam.setPublished(false);
		exam.setUser(user);

		service.saveExam(exam);
		
		return "redirect:/teacher/exams";
	}
	
	@GetMapping("/teacher/exams/{examId}/questions")
	public String viewQuestions(@PathVariable int examId, Model model) {
	    Exam exam = examDao.findById(examId)
	            .orElseThrow(() -> new IllegalArgumentException("Exam not found."));

	    model.addAttribute("exam", exam);
	    model.addAttribute("questions", questionService.getQuestionsByExamId(examId));

	    return "view-questions";
	}
	
	@PostMapping("/teacher/exams/{examId}/publish")
	public String publishExam(@PathVariable int examId) {
	    Exam exam = examDao.findById(examId)
	            .orElseThrow(() -> new IllegalArgumentException("Exam not found."));

	    exam.setPublished(true);
	    service.saveExam(exam);

	    return "redirect:/teacher/exams";
	}
	
	@GetMapping("/student/exams/{examId}")
	public String startExam(@PathVariable int examId, Model model) {

	    Exam exam = examDao.findById(examId)
	            .orElseThrow(() -> new IllegalArgumentException("Exam not found."));

	    if (!exam.isPublished()) {
	        return "redirect:/student/dashboard";
	    }

	    model.addAttribute("exam", exam);
	    model.addAttribute("questions",
	            questionService.getQuestionsByExamId(examId));

	    return "student-exam";
	}
	@PostMapping("/student/exams/{examId}/submit")
	public String submitExam(@PathVariable int examId,
	        @RequestParam Map<String, String> answers,
	        Model model) {

	    Exam exam = examDao.findById(examId)
	            .orElseThrow(() -> new IllegalArgumentException("Exam not found."));

	    if (!exam.isPublished()) {
	        return "redirect:/student/dashboard";
	    }

	    List<Question> questions = questionService.getQuestionsByExamId(examId);

	    int score = 0;
	    int totalMarks = 0;

	    for (Question question : questions) {
	        totalMarks += question.getMarks();

	        String answer = answers.get("answer_" + question.getId());

	        if (answer != null &&
	                answer.equalsIgnoreCase(question.getCorrectAnswer())) {
	            score += question.getMarks();
	        }
	    }

	    model.addAttribute("exam", exam);
	    model.addAttribute("score", score);
	    model.addAttribute("totalMarks", totalMarks);

	    return "student-result";
	}
}