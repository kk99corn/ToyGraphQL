package com.toy.graphql.data;

import com.toy.graphql.entity.Address;
import com.toy.graphql.entity.Person;
import com.toy.graphql.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {
	private final PersonRepository personRepository;

	public SampleDataLoader(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// 임시 데이터 1
		Person person = Person.builder()
				.firstName("Corn")
				.lastName("kk99")
				.phoneNumber("010.9999.9999")
				.email("gamil@gmail.com")
				.address(Address.builder()
						.address("Street")
						.city("City")
						.state("State")
						.zip("99999")
						.build()
				)
				.build();
		personRepository.save(person);

		// 임시 데이터 2
		person = Person.builder()
				.firstName("Gildong")
				.lastName("Kim")
				.phoneNumber("010.0000.0000")
				.email("gg@gg.com")
				.address(Address.builder()
						.address("st")
						.city("99City")
						.state("-")
						.zip("90081")
						.build())
				.build();
		personRepository.save(person);

		// 임시 데이터 3
		person = Person.builder()
				.firstName("Suo")
				.lastName("Ya")
				.phoneNumber("010.0000.0000")
				.email("ya@suo.com")
				.address(Address.builder()
						.address("Qst")
						.city("Wind-City")
						.state("QWER")
						.zip("030")
						.build())
				.build();
		personRepository.save(person);
	}
}
