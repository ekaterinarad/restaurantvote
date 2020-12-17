package service;

import model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IDishRepository;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private IDishRepository repository;

    @Override
    public Dish findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public Dish addDish(Dish dish) {
        return repository.saveAndFlush(dish);
    }

    @Override
    public void deleteDish(Integer id) {
        repository.deleteById(id);
    }
}
