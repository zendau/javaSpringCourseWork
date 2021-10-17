package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

    private Long id;
    private String username;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
