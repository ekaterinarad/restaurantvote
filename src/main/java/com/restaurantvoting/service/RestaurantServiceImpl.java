package com.restaurantvoting.service;


import com.restaurantvoting.model.Restaurant;
import com.restaurantvoting.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    IRestaurantRepository repository;

    @Override
    public Restaurant addRestaurant(Restaurant rest) {
        return repository.saveAndFlush(rest);
    }

    @Override
    public void deleteRestaurant(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return repository.findAll();
    }
}
