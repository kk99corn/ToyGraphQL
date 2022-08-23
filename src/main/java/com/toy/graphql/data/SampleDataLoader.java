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
		Person person = new Person("Corn",
				"kk99",
				"010.9999.9999",
				"gamil@gmail.com",
				new Address("Street","City","State","99999"));
		personRepository.save(person);

		// 임시 데이터 2
		person = new Person("Gildong",
				"Kim",
				"010.0000.0000",
				"gg@gg.com",
				new Address("st","99City","-","90081"));
		personRepository.save(person);

		// 임시 데이터 3
		person = new Person("Suo",
				"Ya",
				"010.0000.0000",
				"ya@suo.com",
				new Address("Qst","Wind-City","QWER","030"));
		personRepository.save(person);
	}
}
