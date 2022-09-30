package com.toy.graphql.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
public class AddressDto {

	private Integer id;
	private @NotNull String address;
	private @NotNull String city;
	private String state;
	private String zip;
}
