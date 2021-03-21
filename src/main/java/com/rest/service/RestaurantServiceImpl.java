package com.rest.service;


import com.rest.model.Restaurant;
import com.rest.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
