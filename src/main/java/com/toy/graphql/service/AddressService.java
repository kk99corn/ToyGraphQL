package com.toy.graphql.service;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.entity.Address;
import com.toy.graphql.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	private final AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	/**
	 * Address 정보 입력
	 *
	 * @param addressDto AddressDto
	 * @return AddressDto
	 */
	public AddressDto saveAddress(AddressDto addressDto) {
		Address address = addressRepository.save(Address.builder()
				.address(addressDto.getAddress())
				.city(addressDto.getCity())
				.state(addressDto.getState())
				.zip(addressDto.getZip())
				.build());
		addressDto.setId(address.getId());
		return addressDto;
	}
}
