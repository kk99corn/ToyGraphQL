package com.toy.graphql.service;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.dto.PersonDto;
import com.toy.graphql.entity.Address;
import com.toy.graphql.exception.GraphQLNotFoundException;
import com.toy.graphql.entity.Person;
import com.toy.graphql.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<PersonDto> findAll() {
		List<PersonDto> personDtoList = new ArrayList<>();
		List<Person> personList = personRepository.findAll();
		for (Person person : personList) {
			personDtoList.add(PersonDto.builder()
					.id(person.getId())
					.firstName(person.getFirstName())
					.lastName(person.getLastName())
					.phoneNumber(person.getPhoneNumber())
					.email(person.getEmail())
					.address(AddressDto.builder()
							.id(person.getAddress().getId())
							.city(person.getAddress().getCity())
							.state(person.getAddress().getState())
							.zip(person.getAddress().getZip())
							.build())
					.build());
		}
		return personDtoList;
	}

	public PersonDto findById(Integer id) {
		PersonDto personDto;

		Optional<Person> findPerson = personRepository.findById(id);
		if (findPerson.isPresent()) {
			Person person = findPerson.get();
			personDto = PersonDto.builder()
					.id(person.getId())
					.firstName(person.getFirstName())
					.lastName(person.getLastName())
					.phoneNumber(person.getPhoneNumber())
					.email(person.getEmail())
					.address(AddressDto.builder()
							.id(person.getAddress().getId())
							.city(person.getAddress().getCity())
							.state(person.getAddress().getState())
							.zip(person.getAddress().getZip())
							.build())
					.build();
		} else {
			throw new GraphQLNotFoundException("data not found. id=" + id);
		}
		return personDto;
	}
}
