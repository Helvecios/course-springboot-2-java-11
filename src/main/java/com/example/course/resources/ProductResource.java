package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Product;
import com.example.course.services.ProductService;

//annotation para informar que esta classe é um recurso web que é
//implentado por um controlador Rest
@RestController
//dar caminho e nome para o recurso
@RequestMapping(value = "/products")
public class ProductResource {
	
	//criar dependência para o Service
	@Autowired //para que o spring faça a injeção de dependência
	private ProductService service;
	
	@GetMapping //annotation
	//método (end point para acessar os usuários)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //annotation
	//método (end point para acessar usuário pelo id)
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
