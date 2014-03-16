package com.myjpa.sample.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import com.myjpa.sample.domain.Client;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		System.out.println("start ...");
		for(Client client : test.getClients()) {
			System.out.println("Client -->" + client);
			System.out.println("ClientAnswers --> " + client.getClientAnswers());
		}
		System.out.println("... end");
	}


	private List<Client> getClients() {
		Session session = ((Session)manager.getDelegate());
		// this will enable filter for this session.
		session.enableFilter("filterByQuestionId").setParameter("question_id", 1l);
		return session.createCriteria(Client.class).list();
	}


}
