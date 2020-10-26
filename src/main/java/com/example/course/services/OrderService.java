package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Order;
import com.example.course.repositories.OrderRepository;

@Service //annotation
public class OrderService {
	
	//declarar a dependência
	@Autowired //para que o spring faça a injeção de dependência
	private OrderRepository repository;
	
	//metodo para retornar todos usuários do BD
	public List<Order> findAll() {
		return repository.findAll();
	}
	 //método para retornar o usuário pelo id
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
