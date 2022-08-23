package com.toy.graphql.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class AddressDto {

	private Integer id;
	private String address;
	private String city;
	private String state;
	private String zip;
}
