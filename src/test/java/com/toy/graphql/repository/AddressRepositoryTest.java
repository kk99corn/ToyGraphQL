package com.toy.graphql.repository;

import com.toy.graphql.entity.Address;
import com.toy.graphql.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressRepositoryTest {

	@Autowired
	AddressRepository addressRepository;

	@DisplayName("findById 테스트")
	@Test
	void findById() {
		// given
		Integer id = 2;

		// when
		Optional<Address> address = addressRepository.findById(id);

		// then
		if (address.isPresent()) {
			assertThat(address.get().getId()).isEqualTo(id);
			assertThat(address.get().getZip()).isEqualTo("99999");
		}
	}

	@DisplayName("findById 테스트 - No data")
	@Test
	void findById2() {
		// given
		Integer id = 999;

		// when
		Optional<Address> address = addressRepository.findById(id);

		// then
		assertThat(address.isPresent()).isFalse();
	}

	@DisplayName("save 테스트")
	@Test
	void save() {
		// given
		String address = "address";
		String city = "city";
		String state = "state";
		String zip = "zip";

		// when
		Address saveAddress = addressRepository.save(new Address(
				address,
				city,
				state,
				zip
		));

		// then
		assertThat(saveAddress).isNotNull();
		assertThat(saveAddress.getId()).isGreaterThan(0);
		assertThat(saveAddress.getAddress()).isEqualTo(address);
	}
}