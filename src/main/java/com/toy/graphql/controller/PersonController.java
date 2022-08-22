package com.toy.graphql.controller;

import com.toy.graphql.model.Person;
import com.toy.graphql.service.PersonService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@SchemaMapping(typeName = "Query", value = "findAll")
	public List<Person> findAll() {
		return personService.findAll();
	}

	@SchemaMapping(typeName = "Query", value = "findById")
	public Person findById(@Argument Integer id) {
		return personService.findById(id);
	}
}
