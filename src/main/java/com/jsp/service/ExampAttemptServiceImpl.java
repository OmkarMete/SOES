package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.dao.ExamAttemptDao;
import com.jsp.entity.ExamAttempt;

@Service
public class ExampAttemptServiceImpl {
	
	@Autowired
	private ExamAttemptDao repo;
	
	public ExamAttempt saveAttempt(ExamAttempt attempt) {
        return repo.save(attempt);
    }

    public List<ExamAttempt> getAllAttempts() {
        return repo.findAll();
    }
}