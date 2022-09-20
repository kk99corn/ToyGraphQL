package com.toy.graphql.cofig;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Map;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import static graphql.scalars.ExtendedScalars.Object;

/**
 * <pre>
 * JsonNode Coercing
 * 참고: <a href="https://stackoverflow.com/questions/72915766/spring-graphql-how-to-map-json-extended-scalar-to-pojo-attribute">https://stackoverflow.com/questions/72915766/spring-graphql-how-to-map-json-extended-scalar-to-pojo-attribute</a>
 * </pre>
 *
 * @since 2022. 09. 20.
 */
public class JsonNodeCoercing implements Coercing<JsonNode, Object> {

	private static final Coercing<?, ?> COERCING = Object.getCoercing();

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Object serialize(Object input) throws CoercingSerializeException {
		return input;
	}

	@Override
	public JsonNode parseValue(Object input) throws CoercingParseValueException {
		return objectMapper.valueToTree(input);
	}

	@Override
	public JsonNode parseLiteral(Object input) throws CoercingParseLiteralException {
		return parseLiteral(input, Collections.emptyMap());
	}

	@Override
	public JsonNode parseLiteral(Object input, Map<String, Object> variables) throws CoercingParseLiteralException {
		return objectMapper.valueToTree(COERCING.parseLiteral(input, variables));
	}

}
