package com.toy.graphql.service;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressServiceTest {

	@Autowired
	AddressService addressService;

	@DisplayName("save 테스트")
	@Test
	void saveAddress() {
		// given
		String address = "address";
		String city = "city";
		String state = "state";
		String zip = "zip";

		// when
		AddressDto addressDto = addressService.saveAddress(AddressDto.builder()
				.address(address)
				.city(city)
				.state(state)
				.zip(zip)
				.build());

		// then
		assertThat(addressDto).isNotNull();
		assertThat(addressDto.getId()).isGreaterThan(0);
		assertThat(addressDto.getAddress()).isEqualTo(address);
	}
}