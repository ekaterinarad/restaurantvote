package com.rest.service;


import com.rest.model.Restaurant;

import java.util.List;

public interface RestaurantService{
    Restaurant addRestaurant(Restaurant rest);

    void deleteRestaurant(Integer id);

    List<Restaurant> getRestaurants();
}
