package com.jsp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Exam;

@Repository
public interface ExamDao extends JpaRepository<Exam, Integer>{
	 List<Exam> findByPublishedTrue();

}
