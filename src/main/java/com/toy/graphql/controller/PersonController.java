package com.toy.graphql.controller;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.dto.PersonDto;
import com.toy.graphql.exception.GraphQLBadRequestException;
import com.toy.graphql.service.PersonService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
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
	 * @param firstName String
	 * @param lastName String
	 * @param phoneNumber String
	 * @param email String
	 * @param addressId Integer
	 * @return PersonDto
	 */
	@MutationMapping(value = "person")
	public PersonDto savePerson(@Argument String firstName,
								@Argument String lastName,
								@Argument String phoneNumber,
								@Argument String email,
								@Argument Integer addressId) {
		PersonDto personDto = PersonDto.builder()
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
}
