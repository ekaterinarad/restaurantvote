package com.restaurantvoting.repository;


import com.restaurantvoting.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IMenuRepository extends JpaRepository<Menu, Integer> {
List<Menu> findByDate(LocalDate date);
}
