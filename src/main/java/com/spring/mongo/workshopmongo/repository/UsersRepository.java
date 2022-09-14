package com.spring.mongo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.mongo.workshopmongo.domain.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String>{
	
}
