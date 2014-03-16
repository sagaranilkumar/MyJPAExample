package com.myjpa.sample.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * The persistent class for the client_answer database table.
 * 
 */
@Entity
@Table(name="client_answer")
public class ClientAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientAnswerPK id;

	public ClientAnswer() {
	}

	public ClientAnswerPK getId() {
		return this.id;
	}

	public void setId(ClientAnswerPK id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}