package com.toy.graphql.service;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.entity.Address;
import com.toy.graphql.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
				.id(addressDto.getId())
				.address(addressDto.getAddress())
				.city(addressDto.getCity())
				.state(addressDto.getState())
				.zip(addressDto.getZip())
				.build());
		addressDto.setId(address.getId());
		return addressDto;
	}

	/**
	 * 전체 Address 정보 조회
	 *
	 * @return List<AddressDto>
	 */
	public List<AddressDto> findAll() {
		List<AddressDto> addressDtoList = new ArrayList<>();
		List<Address> addressList = addressRepository.findAll();
		for (Address address: addressList) {
			addressDtoList.add(AddressDto.builder()
					.id(address.getId())
					.address(address.getAddress())
					.city(address.getCity())
					.state(address.getState())
					.zip(address.getZip())
					.build());
		}
		return addressDtoList;
	}
}
