package com.example.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;

//annotation para informar que esta classe é um recurso web que é
//implentado por um controlador Rest
@RestController
//dar caminho e nome para o recurso
@RequestMapping(value = "/users")
public class UserResource {
	
	//annotation
	@GetMapping
	//método (end point par acessar os usuários)
	public ResponseEntity<User> findAll() {
		//instaciar um usuário
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	

}
