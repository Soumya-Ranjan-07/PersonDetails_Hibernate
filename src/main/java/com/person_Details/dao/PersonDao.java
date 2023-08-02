package com.person_Details.dao;

import java.util.List;

import com.person_Details.dto.Person;

public interface PersonDao {
	public String save(Person person);
	public String update(Person person);
	public void findAll();
	public Person findById(int sid);
	public String delete(int id);
}
