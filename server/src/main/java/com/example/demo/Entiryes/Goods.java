package com.example.demo.Entiryes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Goods {

    private String name;
    private String category;
    private String image;
    private String description;
    private int storageId;

    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return this.category;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }
    @Id
    public int getStorageId() {
        return this.storageId;
    }
}
