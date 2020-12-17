package service;

import model.Restaurant;

public interface RestaurantService{
    Restaurant addRestaurant(Restaurant rest);

    void deleteRestaurant(Integer id);
}
