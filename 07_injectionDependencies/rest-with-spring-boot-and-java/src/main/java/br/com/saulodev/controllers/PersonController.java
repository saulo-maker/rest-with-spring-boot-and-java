package br.com.saulodev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulodev.model.Person;
import br.com.saulodev.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	// private PersonServices service = new PersonServices();
	
	@RequestMapping(value= "/{id}",	method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) throws Exception {	
		return service.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,  // A partir do produces irá produzir um JSON de retorno
			consumes = MediaType.APPLICATION_JSON_VALUE) // A partir da body irá 
	public Person create(@RequestBody Person person) throws Exception {	
		return service.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,  // A partir do produces irá produzir um JSON de retorno
			consumes = MediaType.APPLICATION_JSON_VALUE) // A partir da body irá 
	public Person update(@RequestBody Person person) throws Exception {	
		return service.update(person);
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) throws Exception {	
		service.delete(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {	
		return service.findAll();
	}
}
