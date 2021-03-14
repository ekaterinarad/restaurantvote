package com.restaurantvoting.controller;


import com.restaurantvoting.model.Dish;
import com.restaurantvoting.model.Menu;
import com.restaurantvoting.model.Restaurant;
import com.restaurantvoting.service.DishService;
import com.restaurantvoting.service.MenuService;
import com.restaurantvoting.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DishService dishService;

    @Autowired
    MenuService menuService;

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/dishes")
    @ResponseBody
    public Dish addDish(@RequestBody Dish dish) {
        logger.info("dish added name = {}, price = {}", dish.getName(), dish.getPrice());
        return dishService.addDish(dish);
    }

    @PostMapping("/menus")
    public Menu addMenu(@RequestBody Menu menu) {

        logger.info("menu added name = {}", menu.getName());
        return menuService.addMenu(menu);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant rest) {

        return restaurantService.addRestaurant(rest);}

    @RequestMapping(value="/dishes/{id}", method = RequestMethod.DELETE)
    public void deleteDish(@PathVariable("id") Integer id) {dishService.deleteDish(id);}

    @RequestMapping(value="/restaurants/{id}", method=RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable("id") Integer id) {restaurantService.deleteRestaurant(id);}

    @RequestMapping(value="/menus/{id}", method=RequestMethod.DELETE)
    public void deleteMenu(@PathVariable("id") Integer id) {menuService.deleteMenu(id);}

    @GetMapping("/dishes")
    public List<Dish> getAllDishes() {
        logger.info("all dishes displayed");
        return dishService.findAll();
    }

    @GetMapping("/menus")
    public List<Menu> getMenu() {
        logger.info("all menus displayed");
        return menuService.getMenus();
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        logger.info("all restaurants displayed");
        return restaurantService.getRestaurants();
    }
}
