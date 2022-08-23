package com.toy.graphql.controller;

import com.toy.graphql.service.PersonService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class PersonControllerTest {

//	@Autowired
//	PersonController personController;
//
//	@Autowired
//	MockMvc mockMvc;
//
//	@MockBean
//	PersonService personService;
//
//	@Test
//	void findAll() throws Exception {
//		MvcResult mvcResult = mockMvc.perform(post("/graphql")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{\"query\":\"query{findAll {id firstName}}\"}"))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andReturn();
//		String content = mvcResult.getResponse().getContentAsString();
//
//		System.out.println("content = " + content);
//	}
//	@Test
//	public void getUsers() throws Exception {
//		// Given
//		String query = "query{findAll {id firstName}}";
//
//		// When
//		ResultActions postResult = performGraphQlPost(query);
//
//		// Then
//		postResult.andExpect(status().isOk())
//				.andExpect(jsonPath("$.errors").doesNotExist())
//				.andExpect(jsonPath("$.data.findAll[0].id").value("1"))
//				.andExpect(jsonPath("$.data.findAll[0].firstName").value("Corn"));
//	}
//
//	private ResultActions performGraphQlPost(String query) throws Exception {
//		return performGraphQlPost(query, null);
//	}
//
//	private ResultActions performGraphQlPost(String query, Map<String, String> variables) throws Exception {
//		return mockMvc.perform(post("/graphql")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(generateRequest(query, variables))
//		);
//	}
//
//	private String generateRequest(String query, Map<String, String> variables) throws JSONException {
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("query", query);
//
//		if (variables != null) {
//			jsonObject.put("variables", Collections.singletonMap("input", variables));
//		}
//
//		return jsonObject.toString();
//	}
}