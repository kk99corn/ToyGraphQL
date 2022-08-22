package com.toy.graphql.exception;

import org.springframework.http.HttpStatus;

public class GraphQLNotFoundException extends GraphQLCustomException {
	public GraphQLNotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND, "Resource not found");
	}
}
