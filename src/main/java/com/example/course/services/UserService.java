package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

@Service //annotation
public class UserService {
	
	//declarar a dependência
	@Autowired //para que o spring faça a injeção de dependência
	private UserRepository repository;
	
	//metodo para retornar todos usuários do BD
	public List<User> findAll() {
		return repository.findAll();
	}
	 //método para retornar o usuário pelo id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	//método para salvar um usuário no BD
	public User insert(User obj) {
		return repository.save(obj);
	}
	
}
