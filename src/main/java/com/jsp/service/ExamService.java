package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.dao.ExamDao;
import com.jsp.entity.Exam;

@Service
public class ExamService {

    @Autowired
    private ExamDao dao;

    public Exam saveExam(Exam exam) {
        return dao.save(exam);
    }

    public List<Exam> getAllExams() {
        return dao.findAll();
    }

    public void deleteExam(int id) {
        dao.deleteById(id);
    }
    
    public List<Exam> getPublishedExams() {
        return dao.findByPublishedTrue();
    }
}