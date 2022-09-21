package com.spring.mongo.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.workshopmongo.domain.Users;
import com.spring.mongo.workshopmongo.dto.UsersDTO;
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
	public ResponseEntity<List<UsersDTO>> findAll() {

		List<Users> usersList = service.findAll();
		List<UsersDTO> usersListDto = usersList.stream().map(x -> new UsersDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(usersListDto);
	}

}
