package com.rest.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "global_seq"
    )
    @SequenceGenerator(
            name = "global_seq",
            allocationSize = 1
    )
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="date")
    private LocalDateTime date;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private List<Dish> dishes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
