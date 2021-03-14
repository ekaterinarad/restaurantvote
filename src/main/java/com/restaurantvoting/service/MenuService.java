package com.restaurantvoting.service;


import com.restaurantvoting.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface MenuService {
    Menu addMenu(Menu menu);

    void deleteMenu(Integer id);

    List<Menu> getMenus();

    List<Menu> getMenuOfToday(LocalDate date);
}
