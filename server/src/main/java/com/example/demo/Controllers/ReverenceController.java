package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/reverence")
public class ReverenceController {

    private Connection connection;

    ReverenceController() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?autoReconnect=true", "root", "");
    }

    @GetMapping("/workers")
    public ArrayList getWorkers() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM workers";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList worker;

        ArrayList workers = new ArrayList();

        while (resultSet.next()) {
            worker = new ArrayList<>();

            worker.add(resultSet.getInt("workerId"));
            worker.add(resultSet.getString("name"));
            worker.add(resultSet.getString("role"));
            worker.add(resultSet.getString("birthday"));
            worker.add(resultSet.getString("phone"));
            worker.add(resultSet.getString("address"));
            worker.add(resultSet.getString("salary"));

            workers.add(worker);
        }

        return workers;

    }

    @GetMapping("/sales")
    public ArrayList getSales() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT sales.id, name, stockcontrolcard.price , arrivadDate, issueDate, mailOfBuyer, sales.count, waybillName FROM sales INNER JOIN stockcontrolcard ON sccId = stockcontrolcard.id INNER JOIN goods ON itemId = goods.id INNER JOIN waybill ON waybill.SccId = stockcontrolcard.id WHERE issueDate IS NOT NULL";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList saleItem;

        ArrayList saleItems = new ArrayList();

        while (resultSet.next()) {
            saleItem = new ArrayList<>();

            saleItem.add(resultSet.getString("id"));
            saleItem.add(resultSet.getString("name"));
            saleItem.add(resultSet.getString("price"));
            saleItem.add(resultSet.getString("arrivadDate"));
            saleItem.add(resultSet.getString("issueDate"));
            saleItem.add(resultSet.getString("mailOfBuyer"));
            saleItem.add(resultSet.getString("count"));
            saleItem.add(resultSet.getString("waybillName"));

            saleItems.add(saleItem);
        }

        return saleItems;

    }

}
