package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Category;
import com.example.course.services.CategoryService;

//annotation para informar que esta classe é um recurso web que é
//implentado por um controlador Rest
@RestController
//dar caminho e nome para o recurso
@RequestMapping(value = "/categories")
public class CaterogyResource {
	
	//criar dependência para o Service
	@Autowired //para que o spring faça a injeção de dependência
	private CategoryService service;
	
	@GetMapping //annotation
	//método (end point para acessar os usuários)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //annotation
	//método (end point para acessar usuário pelo id)
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
