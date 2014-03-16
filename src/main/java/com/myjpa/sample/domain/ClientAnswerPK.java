package com.myjpa.sample.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * The primary key class for the client_answer database table.
 * 
 */
@Embeddable
public class ClientAnswerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="client_id")
	private int clientId;

	@Column(name="question_id")
	private int questionId;

	@Column(name="answer_type")
	private String answerType;

	public ClientAnswerPK() {
	}
	public int getClientId() {
		return this.clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
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
		if (!(other instanceof ClientAnswerPK)) {
			return false;
		}
		ClientAnswerPK castOther = (ClientAnswerPK)other;
		return 
			(this.clientId == castOther.clientId)
			&& (this.questionId == castOther.questionId)
			&& this.answerType.equals(castOther.answerType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clientId;
		hash = hash * prime + this.questionId;
		hash = hash * prime + this.answerType.hashCode();
		
		return hash;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}