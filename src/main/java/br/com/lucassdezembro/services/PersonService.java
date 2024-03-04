package br.com.lucassdezembro.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.lucassdezembro.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person getPersonById(String id) {
		logger.info("Searching one person...");
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Lucas");
		person.setLastName("Dezembro");
		person.setAddress("Nova Odessa - São Paulo - Brasil");
		person.setGender("M");
		
		logger.info(String.format("Person %s found!", counter.get()));
		
		return person;
	}
}
