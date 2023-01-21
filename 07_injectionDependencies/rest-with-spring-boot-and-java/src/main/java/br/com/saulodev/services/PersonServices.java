package br.com.saulodev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.saulodev.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 18; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person findById(String id) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFisrtName("Paulo");
		person.setLastName("Constantino");
		person.setAddress("Goiania - Goias - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("Create one person!");
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("deleting one person!");
		
	}
	
	private Person mockPerson(int i) {
		
		logger.info("Finding all people!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFisrtName("Person name:" + i);
		person.setLastName("Last name:" + i);
		person.setAddress("Some address: Goiania - Goias - Brasil" + i);
		person.setGender("Male");
		return person;
	}

}
