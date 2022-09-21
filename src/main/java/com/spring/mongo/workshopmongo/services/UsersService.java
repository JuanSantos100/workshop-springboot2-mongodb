package com.spring.mongo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.workshopmongo.domain.Users;
import com.spring.mongo.workshopmongo.dto.UsersDTO;
import com.spring.mongo.workshopmongo.repository.UsersRepository;
import com.spring.mongo.workshopmongo.services.exception.ObjectNotFoundException;

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
	
	public Users findById(String id) {
		Optional<Users> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
				
		}
	
	public Users insert(Users obj) {
		return repository.insert(obj);
	}
	
	//Método construído nesta classe devido a já ter comunicação com o banco de dados nesta camada.
	public Users fromDTO (UsersDTO objDto) {
		return new Users(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void deleteUsers (String id) {
		findById(id);
		repository.deleteById(id);
	}
}
