package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.dao.QuestionDao;
import com.jsp.entity.Question;

@Service
public class QuestionServiceImpl {

	@Autowired
	private QuestionDao dao;

	public Question saveQuestion(Question question) {
		return dao.save(question);
	}

	public List<Question> getAllQuestions() {
		return dao.findAll();
	}

	public void deleteQuestion(int id) {
		dao.deleteById(id);
	}
}