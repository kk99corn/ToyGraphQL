package com.toy.graphql.service;

import com.toy.graphql.dto.PersonDto;
import com.toy.graphql.exception.GraphQLNotFoundException;
import com.toy.graphql.entity.Person;
import com.toy.graphql.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findById(Integer id) {
		Person person;

		Optional<Person> findPerson = personRepository.findById(id);
		if (findPerson.isPresent()) {
			person = findPerson.get();
		} else {
			throw new GraphQLNotFoundException("data not found. id=" + id);
		}
		return person;
	}
}
