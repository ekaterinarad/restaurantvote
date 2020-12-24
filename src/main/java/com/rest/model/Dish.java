package com.rest.model;


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
    private int id;

    @Column(name="name")
    private String name;

  /*  @Column(name="menu_id")
    private int menu_id;
*/
    @Column(name="price")
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

/*    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }*/

}

