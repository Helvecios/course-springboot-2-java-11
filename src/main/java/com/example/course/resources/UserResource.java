package com.example.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.course.entities.User;
import com.example.course.services.UserService;

//annotation para informar que esta classe é um recurso web que é
//implentado por um controlador Rest
@RestController
//dar caminho e nome para o recurso
@RequestMapping(value = "/users")
public class UserResource {
	
	//criar dependência para o Service
	@Autowired //para que o spring faça a injeção de dependência
	private UserService service;
	
	@GetMapping //annotation
	//método (end point para acessar os usuários)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //annotation
	//método (end point para acessar usuário pelo id)
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	//método para salvar um usuário no BD
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj); //para executar o método insert do service
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}") //annotation
	//método para deletar um usuário do BD
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id); //para executar o método delete do service
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}") //annotation
	//método para atualizar o usuário
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj ) {
		obj = service.update(id, obj); //para executar o método update do service
		return ResponseEntity.ok().body(obj);
	}
}
