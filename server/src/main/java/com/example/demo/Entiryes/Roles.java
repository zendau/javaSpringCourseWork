package com.example.demo.Entiryes;

import javax.persistence.Id;

public class Roles {

    private String role;
    private String description;



    public void setRole(String role) {this.role = role;}
    @Id
    public String getRole() {
        return this.role;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }



}
