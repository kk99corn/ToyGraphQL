package com.toy.graphql.repository;

import com.toy.graphql.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@DisplayName("findAll 테스트")
	@Test
	void findAll() {
		// given

		// when
		List<Person> personList = personRepository.findAll();

		// then
		assertThat(personList.size()).isGreaterThan(0);
	}

	@DisplayName("findById 테스트")
	@Test
	void findById() {
		// given
		Integer id = 1;

		// when
		Optional<Person> person = personRepository.findById(id);

		// then
		if (person.isPresent()) {
			assertThat(person.get().getId()).isEqualTo(id);
			assertThat(person.get().getFirstName()).isEqualTo("Corn");
		}
	}

	@DisplayName("findById 테스트 - No data")
	@Test
	void findById2() {
		// given
		Integer id = 999;

		// when
		Optional<Person> person = personRepository.findById(id);

		// then
		assertThat(person.isPresent()).isFalse();
	}
}