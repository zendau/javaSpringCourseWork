package com.example.demo.Controllers;

import com.example.demo.Entiryes.*;
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

    @GetMapping("/allCategories")
    public ArrayList getAllCategories() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM categories";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList categories = new ArrayList<>();
        ArrayList category;

        while (resultSet.next()) {

            category = new ArrayList<>();

            category.add(resultSet.getString("id"));
            category.add(resultSet.getString("name"));
            category.add(resultSet.getString("description"));

            categories.add(category);
        }

        return categories;

    }

    @GetMapping("/providers")
    public ArrayList getProviders() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM providers";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList providers = new ArrayList<>();
        ArrayList provider;

        while (resultSet.next()) {

            provider = new ArrayList<>();

            provider.add(resultSet.getString("providerId"));
            provider.add(resultSet.getString("name"));
            provider.add(resultSet.getString("phone"));
            provider.add(resultSet.getString("waybillId"));

            providers.add(provider);
        }

        return providers;

    }

    @GetMapping("/workers")
    public ArrayList getWorkers() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM workers";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList workers = new ArrayList<>();
        ArrayList worker;

        while (resultSet.next()) {

            worker = new ArrayList<>();

            worker.add(resultSet.getString("workerId"));
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

    @GetMapping("/roles")
    public ArrayList getRoles() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM roles";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList roles = new ArrayList<>();
        ArrayList role;

        while (resultSet.next()) {

            role = new ArrayList<>();

            role.add(resultSet.getString("id"));
            role.add(resultSet.getString("role"));
            role.add(resultSet.getString("description"));

            roles.add(role);
        }

        return roles;

    }

    @GetMapping("/allStorages")
    public ArrayList getAllStorages() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM storage";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList storages = new ArrayList<>();
        ArrayList storage;

        while (resultSet.next()) {

            storage = new ArrayList<>();

            storage.add(resultSet.getString("id"));
            storage.add(resultSet.getString("workerId"));
            storage.add(resultSet.getString("address"));
            storage.add(resultSet.getString("SccId"));

            storages.add(storage);
        }

        return storages;

    }

    @GetMapping("/SCCs")
    public ArrayList getSCCs() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM stockcontrolcard";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList stockcontrolcards = new ArrayList<>();
        ArrayList stockcontrolcard;

        while (resultSet.next()) {

            stockcontrolcard = new ArrayList<>();

            stockcontrolcard.add(resultSet.getString("id"));
            stockcontrolcard.add(resultSet.getString("price"));
            stockcontrolcard.add(resultSet.getString("arrivadDate"));
            stockcontrolcard.add(resultSet.getString("issueDate"));
            stockcontrolcard.add(resultSet.getString("place"));

            stockcontrolcards.add(stockcontrolcard);
        }

        return stockcontrolcards;

    }

    @GetMapping("/waybills")
    public ArrayList getWaybills() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM waybill";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList waybills = new ArrayList<>();
        ArrayList waybill;

        while (resultSet.next()) {

            waybill = new ArrayList<>();

            waybill.add(resultSet.getString("id"));
            waybill.add(resultSet.getString("createdDate"));
            waybill.add(resultSet.getString("itemId"));
            waybill.add(resultSet.getString("count"));
            waybill.add(resultSet.getString("price"));
            waybill.add(resultSet.getString("SccId"));
            waybill.add(resultSet.getString("waybillName"));
            waybill.add(resultSet.getString("recipientId"));

            waybills.add(waybill);
        }

        return waybills;

    }

    @GetMapping("/couriers")
    public ArrayList getCouriers() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM workers w WHERE w.role LIKE \"Курьер\"";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList couriers = new ArrayList<>();

        ArrayList courier;

        while (resultSet.next()) {

            courier = new ArrayList<>();

            courier.add(resultSet.getString("workerId"));
            courier.add(resultSet.getString("name"));

            couriers.add(courier);
        }

        return couriers;

    }

    @GetMapping("/items")
    public ArrayList getItems() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM goods";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList items = new ArrayList<>();

        ArrayList item;

        while (resultSet.next()) {

            item = new ArrayList<>();

            item.add(resultSet.getString("id"));
            item.add(resultSet.getString("name"));
            item.add(resultSet.getString("category"));
            item.add(resultSet.getString("image"));
            item.add(resultSet.getString("description"));
            item.add(resultSet.getString("storageID"));

            items.add(item);
        }

        return items;

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
    public int addItem(@RequestBody Goods newItem) throws SQLException {

        String SQL = "INSERT INTO goods (name, category, image, description, storageID) VALUE (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, newItem.getName());
        preparedStatement.setString(2, newItem.getCategory());
        preparedStatement.setString(3, newItem.getImage());
        preparedStatement.setString(4, newItem.getDescription());
        preparedStatement.setInt(5, newItem.getStorageId());

        int result = preparedStatement.executeUpdate();

        return result;
    }

    @PostMapping("/addWorkers")
    public int addWorker(@RequestBody Workers newItem) throws SQLException {

        String SQL = "INSERT INTO workers (name, role, birthday, phone, address, salary) VALUE (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, newItem.getWorkerName());
        preparedStatement.setString(2, newItem.getRole());
        preparedStatement.setString(3, newItem.getBirthday());
        preparedStatement.setString(4, newItem.getPhone());
        preparedStatement.setString(5, newItem.getAddress());
        preparedStatement.setInt(6, newItem.getSalary());

        int result = preparedStatement.executeUpdate();

        return result;
    }

    @PostMapping("/addCategories")
    public int addCategories(@RequestBody Categories newItem) throws SQLException {

        String SQL = "INSERT INTO categories (name, description) VALUE (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, newItem.getName());
        preparedStatement.setString(2, newItem.getDescription());

        int result = preparedStatement.executeUpdate();
        return result;
    }

    @PostMapping("/addRoles")
    public int addRoles(@RequestBody Roles newItem) throws SQLException {

        String SQL = "INSERT INTO roles (role, description) VALUE (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, newItem.getRole());
        preparedStatement.setString(2, newItem.getDescription());

        int result = preparedStatement.executeUpdate();
        return result;
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

    @GetMapping("/BookedItems")
    public ArrayList getBookedItems() throws SQLException  {
        Statement statement = connection.createStatement();
        String SQL = "SELECT s.*, g.name FROM sales s INNER JOIN goods g ON s.itemId = g.id WHERE s.courier IS NULL";
        ResultSet resultSet =  statement.executeQuery(SQL);


        ArrayList items = new ArrayList<>();
        ArrayList item;


        while (resultSet.next()) {

            item = new ArrayList<>();

            item.add(resultSet.getString("id"));
            item.add(resultSet.getString("itemId"));
            item.add(resultSet.getString("name"));
            item.add(resultSet.getString("dateOfSale"));
            item.add(resultSet.getString("mailOfBuyer"));
            item.add(resultSet.getString("count"));

            items.add(item);
        }

        return items;
    }

    @PostMapping("/register")
    public int registerItem(@RequestBody RegisterItem newItem) throws SQLException {

        String SQL = "INSERT INTO stockcontrolcard (price, arrivadDate, place) VALUE (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL, new String[]{"id"});
        preparedStatement.setInt(1, newItem.getPrice1());
        preparedStatement.setString(2, newItem.getArrivedDate());
        preparedStatement.setString(3, newItem.getPlace());

        int insertedId = 0;

        int result = preparedStatement.executeUpdate();
        if (result > 0) {

            try { ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    insertedId = rs.getInt(1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }


        SQL = "INSERT INTO waybill (createdDate, itemId, count, price, SccId, waybillName, recipientId) VALUE (?, ?, ?, ?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(SQL,  new String[]{"id"});
        preparedStatement.setString(1, newItem.getArrivedDate());
        preparedStatement.setInt(2, newItem.getName());
        preparedStatement.setInt(3, newItem.getCount());
        preparedStatement.setInt(4, newItem.getPrice2());
        preparedStatement.setInt(5, insertedId);
        preparedStatement.setString(6, newItem.getNumberOfWaybill());
        preparedStatement.setInt(7, newItem.getWorker());

        int insertedIdWaybill = 0;

        result = preparedStatement.executeUpdate();
        if (result > 0) {

            try { ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    insertedIdWaybill = rs.getInt(1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        SQL = "INSERT INTO storage (workerId, address, SccId) VALUE (?, ?, ?)";

        preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, newItem.getWorker());
        preparedStatement.setString(2, newItem.getAddress());
        preparedStatement.setInt(3, insertedId);

        preparedStatement.executeUpdate();

        SQL = "INSERT INTO providers (name, phone, waybillId) VALUE (?, ?, ?)";

        preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, newItem.getProviderName());
        preparedStatement.setString(2, newItem.getProviderPhone());
        preparedStatement.setInt(3, insertedIdWaybill);

        result = preparedStatement.executeUpdate();

        return result;
    }

}
