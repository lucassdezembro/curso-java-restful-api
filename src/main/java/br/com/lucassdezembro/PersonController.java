package br.com.lucassdezembro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucassdezembro.model.Person;
import br.com.lucassdezembro.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable(value = "id") String id) {
		return personService.getPersonById(id);
	}
}
