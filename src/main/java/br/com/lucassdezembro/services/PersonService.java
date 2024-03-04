package br.com.lucassdezembro.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.lucassdezembro.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> getAllPersons() {
		return mockPersons(10);
	}
	
	private List<Person> mockPersons(int qty) {
		
		List<Person> personList = new ArrayList<>();
		
		for (int i = 0; i < qty; i ++) {
			
			AtomicLong atomicLongId = new AtomicLong(i);
			
			Person person = new Person();
			
			person.setId(atomicLongId.get());
			person.setFirstName(String.format("Name %d", i));
			person.setLastName(String.format("Last Name %d", i));
			person.setAddress(String.format("Address %d", i));
			person.setGender(String.format("%d", i));
			
			personList.add(person);
		}
		
		return personList;
	}
	
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
