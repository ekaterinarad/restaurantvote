package com.rest.service;


import com.rest.model.Restaurant;

public interface RestaurantService{
    Restaurant addRestaurant(Restaurant rest);

    void deleteRestaurant(Integer id);
}
