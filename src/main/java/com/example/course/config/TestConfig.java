package com.example.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

//annotation
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//declarar atributo
	@Autowired  //annotation
	private UserRepository userRepository;
	
	
	
	//metodo run - tudo que for colado dentro dele será executado quando a aplicação for iniciada  
	@Override
	public void run(String... args) throws Exception {
		//instanciar objetos
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//salvar users no BD
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	

}
