package com.rest.service;


import com.rest.model.Menu;

import java.util.List;

public interface MenuService {
    Menu addMenu(Menu menu);

    void deleteMenu(Integer id);

    List<Menu> getAllMenus();
}
