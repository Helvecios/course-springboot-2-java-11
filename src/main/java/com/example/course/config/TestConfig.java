package com.example.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.Order;
import com.example.course.entities.User;
import com.example.course.entities.enums.OrderStatus;
import com.example.course.repositories.OrderRepository;
import com.example.course.repositories.UserRepository;

//annotation
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//declarar atributo
	@Autowired  //annotation para que o spring faça a injeção de dependência
	private UserRepository userRepository;
	
	@Autowired  //annotation para que o spring faça a injeção de dependência
	private OrderRepository orderRepository;
	
	//metodo run - tudo que for colado dentro dele será executado quando a aplicação for iniciada  
	@Override
	public void run(String... args) throws Exception {
		//instanciar objetos
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//instanciar objetos e fazendo associação com o cliente "u1", "u2"
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		//salvar users and orders no BD
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	

}
