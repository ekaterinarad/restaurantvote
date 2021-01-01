package com.rest.service;


import com.rest.model.Dish;
import com.rest.model.Menu;
import com.rest.repository.IMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    IMenuRepository repository;

    @Autowired
    DishService dishService;

    @Override
    public Menu addMenu(Menu menu) {

        menu.setDate(LocalDate.now());
        List<Dish> dishes = menu.getDishes();

        for (Dish dish : dishes) {
            if (dish.getId() == null) {
                dishService.addDish(dish);
            }
        }

        return repository.saveAndFlush(menu);
    }

    @Override
    public void deleteMenu(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Menu> getAllMenus() {
        return repository.findAll();
    }

    @Override
    public List<Menu> getMenus() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    @Override
    public List<Menu> getMenuOfToday(LocalDate date) {
        return repository.findByDate(date);
    }
}
