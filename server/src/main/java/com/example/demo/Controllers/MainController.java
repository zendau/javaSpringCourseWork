package com.example.demo.Controllers;

import com.example.demo.Entiryes.Login;
import com.example.demo.Entiryes.Users;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
@RequestMapping
public class MainController {

    private Connection connection;

    public MainController() throws SQLException {

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "");

    }

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }


    @PostMapping("/login")
    public Boolean login(@RequestBody Login loginData) throws SQLException {

        if (loginData.getLogin().equals("root") && loginData.getPassword().equals("root")) {
            return true;
        } else {
            return false;
        }
    }

}