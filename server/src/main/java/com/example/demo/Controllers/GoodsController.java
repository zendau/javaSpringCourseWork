package com.example.demo.Controllers;

import com.example.demo.Entiryes.Goods;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private Connection connection;

    GoodsController() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?autoReconnect=true", "root", "");
    }

    @GetMapping("/category")
    public ArrayList getCategories() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT name FROM categories";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList categories = new ArrayList<>();

        while (resultSet.next()) {

            categories.add(resultSet.getString("name"));
        }

        return categories;

    }

    @GetMapping("/storage")
    public ArrayList getStorages() throws SQLException {


        Statement statement = connection.createStatement();
        String SQL = "SELECT id FROM storage";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList storages = new ArrayList<>();

        while (resultSet.next()) {

            storages.add(resultSet.getInt("id"));
        }

        return storages;
    }

    @PostMapping("/add")
    public void addItem(@RequestBody Goods newItem) {
        System.out.println(newItem.getName() + " " + newItem.getCategory() + " " + newItem.getImage());
    }

    @GetMapping("/all")
    public ArrayList getAllItems() throws SQLException {



        Statement statement = connection.createStatement();
        String SQL = "SELECT g.*, s1.price FROM goods g INNER JOIN storage s ON g.storageID = s.id INNER JOIN stockcontrolcard s1 ON s.SccId = s1.id\n";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList item ;

        ArrayList items = new ArrayList<>();

        while (resultSet.next()) {

            item = new ArrayList<>();

            item.add(resultSet.getInt("id"));
            item.add(resultSet.getString("name"));
            item.add(resultSet.getString("category"));
            item.add(resultSet.getString("image"));
            item.add(resultSet.getString("price"));

            items.add(item);
        }


        return items;
    }

    @GetMapping("/item")
    public ArrayList getOneItem(@RequestParam int id) throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT g.name, g.category, g.image, g.description, s1.price FROM goods g INNER JOIN storage s ON g.storageID = s.id INNER JOIN stockcontrolcard s1 ON s.SccId = s1.id WHERE g.id = " + id;
        ResultSet resultSet =  statement.executeQuery(SQL);


        ArrayList item = new ArrayList<>();

        while (resultSet.next()) {

            item.add(resultSet.getString("name"));
            item.add(resultSet.getString("category"));
            item.add(resultSet.getString("image"));
            item.add(resultSet.getString("description"));
            item.add(resultSet.getString("price"));

        }

        return item;



    }

}
