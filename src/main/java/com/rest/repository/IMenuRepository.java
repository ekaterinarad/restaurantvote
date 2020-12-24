package com.rest.repository;


import com.rest.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuRepository extends JpaRepository<Menu, Integer> {
}
