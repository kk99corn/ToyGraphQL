package com.toy.graphql.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class PersonDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private AddressDto addressDto;
}
