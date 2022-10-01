package com.toy.graphql.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
public class PersonDto {

	private Integer id;
	private @NotNull String firstName;
	private @NotNull String lastName;
	private String phoneNumber;
	private String email;
	private AddressDto address;
}
