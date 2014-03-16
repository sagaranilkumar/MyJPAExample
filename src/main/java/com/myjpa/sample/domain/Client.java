package com.myjpa.sample.domain;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@FilterDef(name = "filterByQuestionId", parameters = { @ParamDef(name = "question_id", type = "long") })
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	@OneToMany(fetch = LAZY)
	@Filter(name="filterByQuestionId", condition="question_id = :question_id")
	@JoinColumn(name = "client_id", insertable = false, updatable = false, unique = true)
	private List<ClientAnswer> clientAnswers;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClientAnswer> getClientAnswers() {
		return this.clientAnswers;
	}

	public void setClientAnswers(List<ClientAnswer> clientAnswers) {
		this.clientAnswers = clientAnswers;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this.name,ToStringStyle.SIMPLE_STYLE);
	}
}