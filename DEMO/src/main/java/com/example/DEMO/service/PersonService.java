package com.example.DEMO.service;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DEMO.dao.PersonDao;
import com.example.DEMO.model.Person;

@Service
public class PersonService {

	private final PersonDao personDao;
	
	
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}

	@PostMapping
	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
}
