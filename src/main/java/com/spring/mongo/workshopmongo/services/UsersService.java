package com.spring.mongo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.workshopmongo.domain.Users;
import com.spring.mongo.workshopmongo.repository.UsersRepository;

@Service
public class UsersService {
	
	/*
	 * Quando insiro o Autowired, o próprio spring vai fazer a 
	 * instanciação do meu objeto. Injeção de dependência
	 */
	
	@Autowired
	private UsersRepository repository;
	
	public List<Users> findAll() {
		return repository.findAll();
	}
	
}
