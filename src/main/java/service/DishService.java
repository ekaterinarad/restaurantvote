package service;

import model.*;

import java.util.List;

public interface DishService {
    Dish findById(int id);
    List<Dish> findAll();
    Dish addDish(Dish dish);
    void deleteDish(Integer id);
}
