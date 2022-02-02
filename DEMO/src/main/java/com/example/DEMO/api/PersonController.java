package com.example.DEMO.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.DEMO.service.PersonService;
import com.example.DEMO.model.Person;




@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	 
	public void addPerson(@RequestBody Person person){

		personService.addPerson(person);
		
	}
	
	@GetMapping
	public List<Person>getAllPeople(){
		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable ("id") UUID id) {
		return personService.getPersonById(id)
				.orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePersonById(@PathVariable ("id") UUID id) {
		 personService.deletePersonById(id);
	}
	
	@PutMapping(path = "{id}")
	public void updatePersonById(@PathVariable ("id") UUID id,@RequestBody Person person) {
		 personService.updatePersonById(id, person);
	}
	
}
