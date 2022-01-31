package api;

import org.springframework.beans.factory.annotation.Autowired;

import model.Person;
import service.PersonService;

public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	public void addPerson(Person person) {
		personService.addPerson(person);
	}
	
}
