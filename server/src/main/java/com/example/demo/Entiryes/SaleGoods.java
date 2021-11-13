package com.example.demo.Entiryes;

import javax.persistence.Id;

public class SaleGoods {

    private int itemId;
    private int courierId;
    private int count;
    private int saleId;
    private int sccId;

    public void setItemId(int itemId) {this.itemId = itemId;}
    @Id
    public int getItemId() {
        return this.itemId;
    }

    public void setCourierId(int courierId) {this.courierId = courierId;}
    public int getCourierId() {
        return this.courierId;
    }

    public void setCount(int count) {this.count = count;}
    public int getCount() {
        return this.count;
    }

    public void setSaleId(int saleId) {this.saleId = saleId;}
    public int getSaleId() {
        return this.saleId;
    }

    public void setSccId(int sccId) {this.sccId = sccId;}
    public int getSccId() {
        return this.sccId;
    }



}
