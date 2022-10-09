package com.toy.graphql.controller;

import com.toy.graphql.dto.AddressDto;
import com.toy.graphql.service.AddressService;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AddressController {

	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@SchemaMapping(typeName = "Query", value = "findAddressAll")
	public List<AddressDto> findAddressAll() {
		return addressService.findAll();
	}
}
