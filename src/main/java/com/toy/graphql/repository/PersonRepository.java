package com.toy.graphql.repository;

import com.toy.graphql.entity.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	@Override
	@EntityGraph(attributePaths = {"address"})
	List<Person> findAll();
}