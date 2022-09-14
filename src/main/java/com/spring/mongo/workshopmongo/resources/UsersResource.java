package com.spring.mongo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.workshopmongo.domain.Users;
import com.spring.mongo.workshopmongo.services.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

	@Autowired
	private UsersService service;

	/*
	 * //ResponseEntity é um objeto que encapsula uma estrutura necessária para
	 * HTTP, com cabeçalhos, possíveis erros, etc
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Users>> findAll() {

		List<Users> usersList = service.findAll();

		return ResponseEntity.ok().body(usersList);
	}

}
