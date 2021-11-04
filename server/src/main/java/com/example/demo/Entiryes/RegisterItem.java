package com.example.demo.Entiryes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegisterItem {

    private int name;
    private int count;
    private String numberOfWaybill;
    private String arrivedDate;
    private String place;
    private int price1;
    private int price2;
    private int worker;
    private String address;
    private String providerName;
    private String providerPhone;


    public void setName(int name) {
        this.name = name;
    }
    @Id
    public int getName() {
        return this.name;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return this.count;
    }

    public void setNumberOfWaybill(String numberOfWaybill) {
        this.numberOfWaybill = numberOfWaybill;
    }
    public String getNumberOfWaybill() {
        return this.numberOfWaybill;
    }

    public void setArrivedDate(String arrivedDate) {this.arrivedDate = arrivedDate;}
    public String getArrivedDate() {
        return this.arrivedDate;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    public String getPlace() {
        return this.place;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }
    public int getPrice1() {
        return this.price1;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }
    public int getPrice2() {
        return this.price2;
    }

    public void setWorker(int worker) {
        this.worker = worker;
    }
    public int getWorker() {
        return this.worker;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {return this.address;}

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    public String getProviderName() {return this.providerName;}

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }
    public String getProviderPhone() {return this.providerPhone;}

}