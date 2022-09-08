package com.toy.graphql.data;

import com.toy.graphql.entity.Address;
import com.toy.graphql.entity.Person;
import com.toy.graphql.repository.AddressRepository;
import com.toy.graphql.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {
	private final PersonRepository personRepository;
	private final AddressRepository addressRepository;

	public SampleDataLoader(PersonRepository personRepository, AddressRepository addressRepository) {
		this.personRepository = personRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = Address.builder()
				.address("Street")
				.city("City")
				.state("State")
				.zip("99999")
				.build();
		addressRepository.save(address);
		Address address2 = Address.builder()
				.address("st")
				.city("99City")
				.state("-")
				.zip("90081")
				.build();
		addressRepository.save(address2);
		Address address3 = Address.builder()
				.address("Qst")
				.city("Wind-City")
				.state("QWER")
				.zip("030")
				.build();
		addressRepository.save(address3);


		// 임시 데이터 1
		Person person = Person.builder()
				.firstName("Corn")
				.lastName("kk99")
				.phoneNumber("010.9999.9999")
				.email("gamil@gmail.com")
				.address(address)
				.build();
		personRepository.save(person);

		// 임시 데이터 2
		person = Person.builder()
				.firstName("Gildong")
				.lastName("Kim")
				.phoneNumber("010.0000.0000")
				.email("gg@gg.com")
				.address(address2)
				.build();
		personRepository.save(person);

		// 임시 데이터 3
		person = Person.builder()
				.firstName("Suo")
				.lastName("Ya")
				.phoneNumber("010.0000.0000")
				.email("ya@suo.com")
				.address(address3)
				.build();
		personRepository.save(person);
	}
}
