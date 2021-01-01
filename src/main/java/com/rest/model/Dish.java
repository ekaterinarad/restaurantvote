package com.rest.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
//@Embeddable
@Table(name="dishes")
public class Dish {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "global_seq"
    )
    @SequenceGenerator(
            name = "global_seq",
            allocationSize = 1
    )
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

