package com.rest.repository;


import com.rest.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishRepository extends JpaRepository<Dish,Integer>
{


}