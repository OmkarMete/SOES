package com.jsp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	 private ExamAttempt attempt;

    @ManyToOne
    private Question question;
    
    private String selectedAnswer;

	public StudentAnswer(int id, ExamAttempt attempt, Question question, String selectedAnswer) {
		super();
		this.id = id;
		this.attempt = attempt;
		this.question = question;
		this.selectedAnswer = selectedAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ExamAttempt getAttempt() {
		return attempt;
	}

	public void setAttempt(ExamAttempt attempt) {
		this.attempt = attempt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
}