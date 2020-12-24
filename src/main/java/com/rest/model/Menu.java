package com.rest.model;

import javax.persistence.*;
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

/*    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="dishes", joinColumns = @JoinColumn(name="menu_id"))
    private List<Dish> dishes;*/


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
}
