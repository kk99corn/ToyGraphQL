package com.toy.graphql.exception;

import org.springframework.http.HttpStatus;

public class GraphQLBadRequestException extends GraphQLCustomException {
	public GraphQLBadRequestException(String message) {
		super(message, HttpStatus.BAD_REQUEST, "Bad Request");
	}
}
