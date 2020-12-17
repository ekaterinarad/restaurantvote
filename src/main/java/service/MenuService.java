package service;

import model.Menu;

public interface MenuService {
    Menu addMenu(Menu menu);

    void deleteMenu(Integer id);
}
