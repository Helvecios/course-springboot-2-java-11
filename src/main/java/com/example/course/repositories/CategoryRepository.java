package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Category;

//criando uma interface
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
