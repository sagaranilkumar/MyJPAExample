package com.myjpa.sample.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the question_answer database table.
 * 
 */
@Embeddable
public class QuestionAnswerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="question_id")
	private int questionId;

	@Column(name="answer_type")
	private String answerType;

	public QuestionAnswerPK() {
	}
	public int getQuestionId() {
		return this.questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswerType() {
		return this.answerType;
	}
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuestionAnswerPK)) {
			return false;
		}
		QuestionAnswerPK castOther = (QuestionAnswerPK)other;
		return 
			(this.questionId == castOther.questionId)
			&& this.answerType.equals(castOther.answerType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.questionId;
		hash = hash * prime + this.answerType.hashCode();
		
		return hash;
	}
}