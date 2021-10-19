package com.example.demo.Controllers;

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


    @PostMapping
    public ArrayList testPost(@RequestBody Users test) throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM goods";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList test2 ;

        ArrayList test3 = new ArrayList<>();

        while (resultSet.next()) {

            test2 = new ArrayList<>();

            test2.add(resultSet.getInt("id"));
            test2.add(resultSet.getString("name"));
            test2.add(resultSet.getString("category"));
            test2.add(resultSet.getString("image"));
            test2.add(resultSet.getString("description"));

            test3.add(test2);
        }

        System.out.println(test.getId());
        return test3;
    }

}