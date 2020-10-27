package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Product;
import com.example.course.repositories.ProductRepository;

@Service //annotation
public class ProductService {
	
	//declarar a dependência
	@Autowired //para que o spring faça a injeção de dependência
	private ProductRepository repository;
	
	//metodo para retornar todos usuários do BD
	public List<Product> findAll() {
		return repository.findAll();
	}
	 //método para retornar o usuário pelo id
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
