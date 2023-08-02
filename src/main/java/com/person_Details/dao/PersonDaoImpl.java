package com.person_Details.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.person_Details.dto.Person;
import com.person_Details.factory.EntityConnectionFactory;


public class PersonDaoImpl implements PersonDao {

	public String save(Person person)
	{				
		EntityManager em = EntityConnectionFactory.getEntityMan();
		Person p = findById(person.getId());
		
		if (p!=null)
		{
			return "exist";
		}
		else
		{
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.persist(person);
			et.commit();
			return "success";
		}		
	}

	public String update(Person person) {
		EntityManager em = EntityConnectionFactory.getEntityMan();
		Person p = findById(person.getId());
		
		if (p!=null)
		{
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.merge(person);
			et.commit();
			return "success";		
		}
		else		
			return "Noexist";
	}

	public void findAll()
	{
		EntityManager em = EntityConnectionFactory.getEntityMan();
		String hql = "Select c from Person c";
		Query q = em.createQuery(hql);
		List<Person> cl = q.getResultList();
		if (cl != null) {
			
			System.out.printf("ID\t  Name\t\t  \t\t Age \t Gender\t    Phone       \n");
			System.out.println("----------------------------------------------------------------------------");
			for (Person s : cl)
			{
				System.out.printf("%-10s",s.getId());
				System.out.printf("%-30s",s.getName());
				System.out.printf("%-9s",s.getAge());
				System.out.printf("%-9s",s.getGender());
				System.out.printf("%-17s",s.getPhone());
				System.out.print("\n---------------------------------------------------------------------------\n");
			}
			
		}
		else {
			System.out.println("Table is Empty");
		}
	}

	public Person findById(int id) {
		EntityManager em = EntityConnectionFactory.getEntityMan();
		
		Person p = em.find(Person.class, id);
		return p;
	}

	public String delete(int id) {
		EntityManager em = EntityConnectionFactory.getEntityMan();
		Person p = findById(id);
		
		if (p!=null)
		{
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.remove(p);
			et.commit();
			return "success";		
		}
		else		
			return "Noexist";
	}

}
