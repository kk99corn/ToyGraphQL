package com.toy.graphql.repository;

import com.toy.graphql.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	@DisplayName("save 테스트")
	@Test
	void save() {
		// given
		String firstName = "fir_name";
		String lastName = "la_name";
		String phoneNumber = "010-0000-9999";
		String email = "email@email.com";

		// when
		Person person = personRepository.save(
				Person.builder()
						.firstName(firstName)
						.lastName(lastName)
						.phoneNumber(phoneNumber)
						.email(email)
						.address(null)
						.build()
		);

		// then
		assertThat(person).isNotNull();
		assertThat(person.getId()).isGreaterThan(0);
		assertThat(person.getFirstName()).isEqualTo(firstName);
	}

	@DisplayName("save 테스트 - id 입력")
	@Test
	void save2() {
		// given
		Integer id = 1;
		String firstName = "fir_name";
		String lastName = "la_name";
		String phoneNumber = "010-0000-9999";
		String email = "email@email.com";

		// when
		Person person = personRepository.save(
				Person.builder()
						.id(id)
						.firstName(firstName)
						.lastName(lastName)
						.phoneNumber(phoneNumber)
						.email(email)
						.address(null)
						.build()
		);

		// then
		assertThat(person).isNotNull();
		assertThat(person.getId()).isEqualTo(id);
		assertThat(person.getFirstName()).isEqualTo(firstName);
	}

	@DisplayName("delete 테스트")
	@Test
	void delete() {
		// given
		Integer id = 1;

		// when
		personRepository.deleteById(id);

		// then
		Optional<Person> findPerson = personRepository.findById(id);
		assertThat(findPerson).isNotPresent();
	}

	@DisplayName("delete 테스트 - 없는 id")
	@Test
	void delete2() {
		// given
		Integer id = 999;

		// when & then
		Assertions.assertThrows(EmptyResultDataAccessException.class,
				() -> {
					personRepository.deleteById(id);
				});
	}
}