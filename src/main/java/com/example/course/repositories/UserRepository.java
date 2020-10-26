package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.User;

//criando uma interface
public interface UserRepository extends JpaRepository<User, Long> {

}
