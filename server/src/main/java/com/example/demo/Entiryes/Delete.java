package com.example.demo.Entiryes;

import javax.persistence.Id;

public class Delete {

    private String type;
    private int id;

    public void setId(int id) {this.id = id;}
    @Id
    public int getId() {return this.id;}


    public void setType(String type) {this.type = type;}
    public String getType() {return  this.type;}

}
