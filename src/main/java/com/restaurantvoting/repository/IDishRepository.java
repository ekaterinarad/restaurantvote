package com.restaurantvoting.repository;


import com.restaurantvoting.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishRepository extends JpaRepository<Dish,Integer>
{


}