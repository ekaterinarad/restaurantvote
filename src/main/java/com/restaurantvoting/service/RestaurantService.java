package com.restaurantvoting.service;


import com.restaurantvoting.model.Restaurant;

import java.util.List;

public interface RestaurantService{
    Restaurant addRestaurant(Restaurant rest);

    void deleteRestaurant(Integer id);

    List<Restaurant> getRestaurants();
}
