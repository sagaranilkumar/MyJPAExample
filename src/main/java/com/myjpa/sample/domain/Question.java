package com.myjpa.sample.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="question_id")
	private int questionId;

	@Column(name="question_details")
	private String questionDetails;

	public Question() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDetails() {
		return this.questionDetails;
	}

	public void setQuestionDetails(String questionDetails) {
		this.questionDetails = questionDetails;
	}

}