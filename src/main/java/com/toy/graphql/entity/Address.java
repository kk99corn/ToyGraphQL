package com.toy.graphql.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String address;
	private String city;
	private String state;
	private String zip;

	@Builder
	public Address(Integer id, String address, String city, String state, String zip) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
}
