package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;
import com.example.course.services.exceptions.DatabaseException;
import com.example.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //função lambda
	}
	
	//método para salvar um usuário no BD
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//método para deletar um usuário no BD
	public void delete(Long id) {
		try {
		repository.deleteById(id);
				
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//método para atualizar usuário no BD
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //prepara o obj monitorado para vc poder mexer
		updateData(entity, obj); //atualiza os dados do entity baseado nos dados que chegaram no obj
		return repository.save(entity); //salvar no BD o meu entity
	}
	
	//método updateData
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
