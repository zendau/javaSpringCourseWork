package com.example.demo.Entiryes;

import javax.persistence.Id;

public class Providers {

    private String name;
    private String phone;



    public void setName(String name) {this.name = name;}
    @Id
    public String getName() {
        return this.name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }



}
