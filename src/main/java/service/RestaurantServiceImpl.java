package service;

import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IRestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    IRestaurantRepository repository;

    @Override
    public Restaurant addRestaurant(Restaurant rest) {
        return repository.saveAndFlush(rest);
    }

    @Override
    public void deleteRestaurant(Integer id) {
        repository.deleteById(id);
    }
}
