package com.jsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.StudentAnswer;

@Repository
public interface StudentAnswerDao extends JpaRepository<StudentAnswer, Integer>{

}
