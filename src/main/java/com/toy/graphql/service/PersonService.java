package com.toy.graphql.service;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.dto.PersonDto;
import com.toy.graphql.entity.Address;
import com.toy.graphql.exception.GraphQLNotFoundException;
import com.toy.graphql.entity.Person;
import com.toy.graphql.repository.AddressRepository;
import com.toy.graphql.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	private final AddressRepository addressRepository;

	public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
		this.personRepository = personRepository;
		this.addressRepository = addressRepository;
	}

	/**
	 * 전체 Person 정보 조회
	 *
	 * @return List<PersonDto>
	 */
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

	/**
	 * id로 Person 정보 조회
	 *
	 * @param id Integer
	 * @return PersonDto
	 */
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

	/**
	 * Person 정보 입력
	 *
	 * @param personDto PersonDto
	 * @return PersonDto
	 */
	public PersonDto savePerson(PersonDto personDto) {
		AddressDto addressDto;
		Optional<Address> findAddress = addressRepository.findById(personDto.getAddress().getId());
		if (findAddress.isPresent()) {
			Address address = findAddress.get();
			addressDto = AddressDto.builder()
					.id(address.getId())
					.address(address.getAddress())
					.city(address.getCity())
					.state(address.getState())
					.zip(address.getZip())
					.build();

			Person person = personRepository.save(new Person(
					personDto.getFirstName(),
					personDto.getLastName(),
					personDto.getPhoneNumber(),
					personDto.getEmail(),
					address
			));

			personDto.setId(person.getId());
			personDto.setAddress(addressDto);
		} else {
			personDto = null;
		}
		return personDto;
	}
}
