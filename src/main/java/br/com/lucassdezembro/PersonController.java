package br.com.lucassdezembro;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucassdezembro.model.Person;
import br.com.lucassdezembro.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPersonById(@PathVariable(value = "id") String id) {
		return personService.getPersonById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePerson(@PathVariable(value = "id") String id) {
		
		Long longId = Long.parseLong(id);
		AtomicLong atomicId = new AtomicLong(longId);
		
		personService.deletePerson(atomicId);
	}
}
