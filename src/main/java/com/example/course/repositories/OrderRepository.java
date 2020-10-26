package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Order;

//criando uma interface
public interface OrderRepository extends JpaRepository<Order, Long> {

}
