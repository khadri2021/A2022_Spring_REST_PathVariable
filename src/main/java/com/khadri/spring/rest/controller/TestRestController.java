package com.khadri.spring.rest.controller;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@GetMapping("/find/student/{id}")
	public Integer findStudentById(@PathVariable Integer id) {
		return id;
	}

	@GetMapping("/find/student/{id}/{name}")
	public String findStudentByIdAndName(@PathVariable Integer id, @PathVariable String name) {

		return "Id: " + id + " Name: " + name;
	}

	@GetMapping("/find/student/{id}/{name}/{address}")
	public String findStudentByParams(@PathVariable Map<String, String> pathVarMap) {

		return pathVarMap.keySet().stream().collect(Collectors.toList()).toString();
	}
	
	
	@GetMapping(value = {"/find/student/optional/{id}","/find/student/optional"})
	public Integer findStudentByOptionalId(@PathVariable(required = false) Integer id) {
		return id;
	}

}
