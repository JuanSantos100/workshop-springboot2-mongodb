package com.spring.mongo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.workshopmongo.domain.Users;

@RestController
@RequestMapping(value="/users")
public class UsersResource {
	
	
	/*
	 * //ResponseEntity é um objeto que encapsula uma estrutura necessária 
	 * para HTTP, com cabeçalhos, possíveis erros, etc
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Users>> findAll() { 
		Users maria = new Users("1", "Maria Brown", "maria@gmail.com");
		Users alex = new Users("2", "Alex Grim", "alex@gmail.com");
		
		List<Users> usersList = new ArrayList<>();
		
		usersList.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(usersList);
	}
	
}
