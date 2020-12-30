package com.rest.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="username")
    private String name;

    @Column(name="password")
  //  @Transient
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }
}
