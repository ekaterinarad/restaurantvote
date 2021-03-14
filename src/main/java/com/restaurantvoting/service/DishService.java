package com.restaurantvoting.service;


import com.restaurantvoting.model.Dish;

import java.util.List;

public interface DishService {
    Dish findById(int id);
    List<Dish> findAll();
    Dish addDish(Dish dish);
    void deleteDish(Integer id);
}
