package com.spring.mongo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.spring.mongo.workshopmongo.domain.Post;
import com.spring.mongo.workshopmongo.domain.Users;
import com.spring.mongo.workshopmongo.dto.AuthorDTO;
import com.spring.mongo.workshopmongo.repository.PostRepository;
import com.spring.mongo.workshopmongo.repository.UsersRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
		Users alex = new Users(null, "Alex Green", "alex@gmail.com");
		Users bob = new Users(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //necessário fazer a persistência dos usuários inicialmente para que os posts possam ser relacionados
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços !", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
