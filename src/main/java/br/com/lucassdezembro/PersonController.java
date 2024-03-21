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

import br.com.lucassdezembro.exceptions.BadRequestException;
import br.com.lucassdezembro.model.Person;
import br.com.lucassdezembro.services.PersonService;
import br.com.lucassdezembro.utils.VerificationUtils;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPersonById(@PathVariable(value = "id") Long id) throws Exception {
		
		if (!VerificationUtils.isNumber(id.toString())) {
			throw new BadRequestException("Invalid field 'id'");
		}
		
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
	public Person createPerson(@RequestBody Person person) throws Exception {
		if (VerificationUtils.isEmptyOrNull(person.getFirstName())) {
			throw new BadRequestException("Missing 'person.firstName' parameter.");
		}
		return personService.createPerson(person);
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person updatePerson(@RequestBody Person person) {
		if (VerificationUtils.isEmptyOrNull(person.getId())) {
			throw new BadRequestException("Missing 'person.id' parameter.");
		}
		return personService.updatePerson(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePerson(@PathVariable(value = "id") Long id) {
		
		if (!VerificationUtils.isNumber(id.toString())) {
			throw new BadRequestException("Invalid field 'id'");
		}
		
		personService.deletePerson(id);
	}
}
