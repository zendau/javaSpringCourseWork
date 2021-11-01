package com.example.demo.Entiryes;

import javax.persistence.Id;
import javax.persistence.Entity;

public class Workers {

    private int salary;
    private String workerName;
    private String birthday;
    private String address;
    private String role;
    private String phone;


    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Id
    public int getSalary() {
        return this.salary;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
    public String getWorkerName() {
        return this.workerName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getBirthday() {
        return this.birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return this.role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }

}
