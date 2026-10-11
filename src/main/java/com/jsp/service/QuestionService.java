package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.dao.QuestionDao;
import com.jsp.entity.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao repo;

	public Question saveQuestion(Question question) {
		return repo.save(question);
	}

	public List<Question> getAllQuestions() {
		return repo.findAll();
	}

	public void deleteQuestion(int id) {
		repo.deleteById(id);
	}
	
	public List<Question> getQuestionsByExamId(int examId) {
	    return repo.findByExamId(examId);
	}
}