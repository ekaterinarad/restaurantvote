package com.restaurantvoting.repository;


import com.restaurantvoting.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
