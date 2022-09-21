package com.spring.mongo.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	
	@RequestMapping(value= "/{id}",method = RequestMethod.GET)
	public ResponseEntity<UsersDTO> findById(@PathVariable String id) {
		Users obj = service.findById(id);
		return ResponseEntity.ok().body(new UsersDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsersDTO objDto) {
		Users obj= service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value= "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteUsers(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UsersDTO objDto, @PathVariable String id) {
		Users obj= service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	
}
