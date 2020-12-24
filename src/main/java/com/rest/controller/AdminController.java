package com.rest.controller;


import com.rest.model.Dish;
import com.rest.model.Menu;
import com.rest.model.Restaurant;
import com.rest.service.DishService;
import com.rest.service.MenuService;
import com.rest.service.RestaurantService;
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

    @PostMapping(path="/dish")
    @ResponseBody
    public Dish addDish(@RequestBody Dish dish) {
        logger.info("dish added name = {}, price = {}", dish.getName(), dish.getPrice());
        return dishService.addDish(dish);
    }

    @PostMapping("/menu")
    public Menu addMenu(@RequestBody Menu menu) {

        logger.info("menu added name = {}", menu.getName());
        return menuService.addMenu(menu);
    }

    @PostMapping("/restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant rest) {

        return restaurantService.addRestaurant(rest);}

    @RequestMapping(value="/dish/{id}", method = RequestMethod.DELETE)
    public void deleteDish(@PathVariable("id") Integer id) {dishService.deleteDish(id);}

    @RequestMapping(value="/restaurant/{id}", method=RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable("id") Integer id) {restaurantService.deleteRestaurant(id);}

    @RequestMapping(value="/menu/{id}", method=RequestMethod.DELETE)
    public void deleteMenu(@PathVariable("id") Integer id) {menuService.deleteMenu(id);}

    @GetMapping("/all")
    public List<Dish> getAllDishes() {
        logger.info("all dishes displayed");
        return dishService.findAll();
    }
}
