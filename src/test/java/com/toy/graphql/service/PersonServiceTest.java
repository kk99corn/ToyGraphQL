package com.toy.graphql.service;


import com.toy.graphql.dto.PersonDto;
import com.toy.graphql.exception.GraphQLNotFoundException;
import com.toy.graphql.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@DisplayName("findAll 테스트")
	@Test
	void findAll() {
		// given
		// when
		List<PersonDto> personList = personService.findAll();

		// then
		assertThat(personList.size()).isGreaterThan(0);
	}

	@DisplayName("findById 테스트")
	@Test
	void findById() {
		// given
		Integer id = 1;

		// when
		PersonDto person = personService.findById(id);

		// then
		assertThat(person.getId()).isEqualTo(id);
		assertThat(person.getFirstName()).isEqualTo("Corn");
	}

	@DisplayName("findById 테스트 - No data")
	@Test
	void findById2() {
		// given
		Integer id = 999;

		// then
		Assertions.assertThrows(GraphQLNotFoundException.class, () -> {
			// when
			PersonDto person = personService.findById(id);
		});
	}
}