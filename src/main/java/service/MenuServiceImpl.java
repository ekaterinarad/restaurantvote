package service;

import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IMenuRepository;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    IMenuRepository repository;

    @Override
    public Menu addMenu(Menu menu) {
        return repository.saveAndFlush(menu);
    }

    @Override
    public void deleteMenu(Integer id) {
        repository.deleteById(id);
    }
}
