package com.person_Details.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityConnectionFactory {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	static {
		emf = Persistence.createEntityManagerFactory("balaji");
		em = emf.createEntityManager();
	}
	public static EntityManager getEntityMan()
	{
		return em;
	}
}
