package com.toy.graphql.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId", referencedColumnName = "id")
	private Address address;

	@Builder
	public Person(Integer id, String firstName, String lastName, String phoneNumber, String email, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
}
