package br.com.lucassdezembro.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassdezembro.errors.ConstantErrors;
import br.com.lucassdezembro.exceptions.ResourceNotFoundException;
import br.com.lucassdezembro.model.Person;
import br.com.lucassdezembro.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	public Person getPersonById(Long id) {
		logger.info("Searching one person...");
		
	
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ConstantErrors.noPersonFound));
		
		logger.info(String.format("Person %s found!", person.getId()));
		
		return person;
	}

	public Person createPerson(Person person) {
		
		logger.info(String.format("Creating person %d", person.getFirstName()));
		
		Person createdPerson = personRepository.save(person);
		
		logger.info(String.format("Person %d created!", createdPerson.getId()));
	
		return createdPerson;
	}
	
	public Person updatePerson(Person person) {
		
		logger.info(String.format("Updating person %d", person.getId()));
		
		Person foundPerson = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException(ConstantErrors.noPersonFound));
		
		foundPerson.setFirstName(person.getFirstName());
		foundPerson.setLastName(person.getLastName());
		foundPerson.setAddress(person.getAddress());
		foundPerson.setGender(person.getGender());
		
		personRepository.save(foundPerson);
		
		logger.info(String.format("Person %d updated!", foundPerson.getId()));
	
		return foundPerson;
	}
	
	public void deletePerson(Long id) {
		
		logger.info(String.format("Deleting person %d", id));
		
		Person foundPerson = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ConstantErrors.noPersonFound));
		
		personRepository.delete(foundPerson);
		
		logger.info(String.format("Person %d deleted!", id));
	}
}
