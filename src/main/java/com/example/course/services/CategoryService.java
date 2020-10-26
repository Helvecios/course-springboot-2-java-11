package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Category;
import com.example.course.repositories.CategoryRepository;

@Service //annotation
public class CategoryService {
	
	//declarar a dependência
	@Autowired //para que o spring faça a injeção de dependência
	private CategoryRepository repository;
	
	//metodo para retornar todos usuários do BD
	public List<Category> findAll() {
		return repository.findAll();
	}
	 //método para retornar o usuário pelo id
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
