package com.toy.graphql.cofig;

import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQlConfig {
	@Bean
	public RuntimeWiringConfigurer runtimeWiringConfigurer() {
		GraphQLScalarType jsonScalarType = GraphQLScalarType.newScalar()
				.name("JSON")
				.description("A JSON scalar")
				.coercing(new JsonNodeCoercing())
				.build();

		return wiringBuilder -> wiringBuilder
				.scalar(jsonScalarType);
	}
}
