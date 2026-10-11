package com.jsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.ExamAttempt;

@Repository
public interface ExamAttemptDao extends JpaRepository<ExamAttempt, Integer> {

}
