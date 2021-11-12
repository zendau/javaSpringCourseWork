package com.example.demo.Entiryes;

import javax.persistence.Id;

public class BuyGoods {

    private int itemId;
    private String mailOfBuyer;
    private int count;


    public void setItemId(int itemId) {this.itemId = itemId;}
    @Id
    public int getItemId() {
        return this.itemId;
    }

    public void setMailOfBuyer(String mailOfBuyer) {this.mailOfBuyer = mailOfBuyer;}
    public String getMailOfBuyer() {
        return this.mailOfBuyer;
    }

    public void setCount(int count) {this.count = count;}
    public int getCount() {
        return this.count;
    }


}
