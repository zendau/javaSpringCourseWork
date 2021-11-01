package com.example.demo.Entiryes;

import javax.persistence.Id;

public class Categories {

    private String name;
    private String description;



    public void setName(String name) {this.name = name;}
    @Id
    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }


}
