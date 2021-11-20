package com.example.demo.Entiryes;

import javax.persistence.Id;

class Item {
    String id;
    int count;
}

public class BuyBasket {

    private Object[] items;
    private String mailOfBuyer;

    public void setMailOfBuyer(String mailOfBuyer) {this.mailOfBuyer = mailOfBuyer;}
    @Id
    public String getMailOfBuyer() {
        return this.mailOfBuyer;
    }

    public void setItems(Object[] count) {this.items = count;}
    public Object[] getItems() {
        return this.items;
    }

}
