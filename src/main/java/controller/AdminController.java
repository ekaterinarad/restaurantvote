package controller;

import model.Dish;
import model.Menu;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DishService;
import service.MenuService;
import service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DishService dishService;

    @Autowired
    MenuService menuService;

    @Autowired
    RestaurantService restaurantService;

    @PostMapping(path="/dish")
    @ResponseBody
    public Dish addDish(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @PostMapping("/menu")
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @PostMapping("/restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant rest) {return restaurantService.addRestaurant(rest);}

    @RequestMapping(value="/dish/{id}", method = RequestMethod.DELETE)
    public void deleteDish(@PathVariable("id") Integer id) {dishService.deleteDish(id);}

    @RequestMapping(value="/restaurant/{id}", method=RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable("id") Integer id) {restaurantService.deleteRestaurant(id);}

    @RequestMapping(value="/menu/{id}", method=RequestMethod.DELETE)
    public void deleteMenu(@PathVariable("id") Integer id) {menuService.deleteMenu(id);}



    @GetMapping("/all")
    public List<Dish> getAllDishes() {
        return dishService.findAll();
    }
}
