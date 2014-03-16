package com.myjpa.sample.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the question_answer database table.
 * 
 */
@Entity
@Table(name="question_answer")
public class QuestionAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestionAnswerPK id;

	public QuestionAnswer() {
	}

	public QuestionAnswerPK getId() {
		return this.id;
	}

	public void setId(QuestionAnswerPK id) {
		this.id = id;
	}

}