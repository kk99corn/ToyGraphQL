package com.toy.graphql.controller;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.dto.PersonDto;
import com.toy.graphql.exception.GraphQLBadRequestException;
import com.toy.graphql.service.AddressService;
import com.toy.graphql.service.PersonService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonController {

	private final PersonService personService;
	private final AddressService addressService;

	public PersonController(PersonService personService, AddressService addressService) {
		this.personService = personService;
		this.addressService = addressService;
	}

	/**
	 * 전체 Person 정보 조회
	 *
	 * @return List<PersonDto>
	 */
	@SchemaMapping(typeName = "Query", value = "findAll")
	public List<PersonDto> findAll() {
		return personService.findAll();
	}

	/**
	 * id로 Person 정보 조회
	 *
	 * @param id Integer
	 * @return PersonDto
	 */
	@SchemaMapping(typeName = "Query", value = "findById")
	public PersonDto findById(@Argument Integer id) {
		if (id <= 0) throw new GraphQLBadRequestException("id=" + id);
		return personService.findById(id);
	}

	/**
	 * Person 정보 입력
	 *
	 * @param id          Integer
	 * @param firstName   String
	 * @param lastName    String
	 * @param phoneNumber String
	 * @param email       String
	 * @param addressId   Integer
	 * @return PersonDto
	 */
	@MutationMapping(value = "person")
	public PersonDto savePerson(@Argument Integer id,
								@Argument String firstName,
								@Argument String lastName,
								@Argument String phoneNumber,
								@Argument String email,
								@Argument Integer addressId) {
		PersonDto personDto = PersonDto.builder()
				.id(id)
				.firstName(firstName)
				.lastName(lastName)
				.phoneNumber(phoneNumber)
				.email(email)
				.address(AddressDto.builder()
						.id(addressId)
						.build())
				.build();
		return personService.savePerson(personDto);
	}

	/**
	 * Address 정보 입력
	 *
	 * @param id      Integer
	 * @param address String
	 * @param city    String
	 * @param state   String
	 * @param zip     String
	 * @return AddressDto
	 */
	@MutationMapping(value = "address")
	public AddressDto saveAddress(@Argument Integer id,
								  @Argument String address,
								  @Argument String city,
								  @Argument String state,
								  @Argument String zip) {

		AddressDto addressDto = AddressDto.builder()
				.id(id)
				.address(address)
				.city(city)
				.state(state)
				.zip(zip)
				.build();
		return addressService.saveAddress(addressDto);
	}

	@MutationMapping(value = "deletePerson")
	public String deletePerson(@Argument Integer id) {
		personService.deletePerson(id);
		return "OK";
	}
}
