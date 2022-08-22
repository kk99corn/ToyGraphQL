package com.toy.graphql.exception.handler;

import com.toy.graphql.exception.GraphQLBadRequestException;
import com.toy.graphql.exception.GraphQLNotFoundException;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class GraphQLExceptionHandler implements DataFetcherExceptionResolver {

	@Override
	public Mono<List<GraphQLError>> resolveException(Throwable exception, DataFetchingEnvironment environment) {
		if (exception instanceof GraphQLBadRequestException badRequestException) {
			return Mono.just(Collections.singletonList(badRequestException));
		}

		if (exception instanceof GraphQLNotFoundException notFoundException) {
			return Mono.just(Collections.singletonList(notFoundException));
		}

		return Mono.empty();
	}
}