package com.example.demo.Entiryes;

import javax.persistence.Id;

public class Login {

    private String login;
    private String password;

    public void setLogin(String login) {this.login = login;}
    @Id
    public String getLogin() {
        return this.login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

}
