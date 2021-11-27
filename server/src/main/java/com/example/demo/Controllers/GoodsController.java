package com.example.demo.Controllers;

import com.example.demo.Entiryes.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;


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
            storage.add(resultSet.getString("SccId"));
            storage.add(resultSet.getString("itemId"));

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

    @GetMapping("/providerWaybills")
    public ArrayList getProviderWaybills() throws SQLException {

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM providerWaybills";
        ResultSet resultSet =  statement.executeQuery(SQL);

        ArrayList waybills = new ArrayList<>();
        ArrayList waybill;

        while (resultSet.next()) {

            waybill = new ArrayList<>();

            waybill.add(resultSet.getString("id"));
            waybill.add(resultSet.getString("providerId"));
            waybill.add(resultSet.getString("waybillId"));

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
    public String[] addItem(@RequestParam("category") String category,
                       @RequestParam("name") String name,
                       @RequestParam("description") String description,
                       @RequestParam("file") MultipartFile file) throws SQLException {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();


                String type = file.getContentType().split("/")[1];

                String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                Random rnd = new Random();
                StringBuilder sb = new StringBuilder(10);
                for (int i = 0; i < 10; i++)
                    sb.append(chars.charAt(rnd.nextInt(chars.length())));

                String rnbName = sb.toString();

                String fileName = rnbName + "." + type;

                String path = "src/main/resources/static/"+fileName;

                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path)));


                stream.write(bytes);
                stream.close();

                String SQL = "INSERT INTO goods (name, category, image, description) VALUE (?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, category);
                preparedStatement.setString(3, fileName);
                preparedStatement.setString(4, description);

                preparedStatement.executeUpdate();

                return new String[]{fileName};
            } catch (Exception e) {
                return new String[]{"error", "Вам не удалось загрузить " + name + " => " + e.getMessage()};
            }
        } else {
            return new String[]{"error", "Вам не удалось загрузить " + name + " потому что файл пустой."};

        }


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
    public Object addCategories(@RequestBody Categories newItem) {

        String SQL = "INSERT INTO categories (name, description) VALUE (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, newItem.getName());
            preparedStatement.setString(2, newItem.getDescription());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            return e;
        }
    }

    @PostMapping("/addRoles")
    public Object addRoles(@RequestBody Roles newItem) {

        String SQL = "INSERT INTO roles (role, description) VALUE (?, ?)";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, newItem.getRole());
            preparedStatement.setString(2, newItem.getDescription());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            return e;
        }
    }

    @PostMapping("/addProvider")
    public Object addProvider(@RequestBody Providers newItem) {

        String SQL = "INSERT INTO providers (name , phone) VALUE (?, ?)";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, newItem.getName());
            preparedStatement.setString(2, newItem.getPhone());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            return e;
        }
    }

    @GetMapping("/all")
    public ArrayList getAllItems() throws SQLException {



        Statement statement = connection.createStatement();
        String SQL = "SELECT sortDate.id, sortDate.name, sortDate.category, sortDate.image, sortDate.price FROM\n" +
                    "(SELECT \n" +
                    "g.id, g.name, g.category, g.image, s1.arrivadDate, s1.price, s.itemId\n" +
                    "FROM goods g \n" +
                    "INNER JOIN storage s ON s.itemId = g.id \n" +
                    "INNER JOIN stockcontrolcard s1 ON s.SccId = s1.id \n" +
                    "WHERE s1.issueDate IS NULL \n"+
                    "ORDER BY s1.arrivadDate\n" +
                    ")  AS sortDate\n" +
                    "GROUP BY sortDate.itemId\n";
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
        String SQL = "SELECT sortDate.id, sortDate.name, sortDate.category, sortDate.image, sortDate.description, sortDate.price, COUNT(sortDate.price) as count FROM\n" +
                        "(SELECT \n" +
                        "g.id, g.name, g.category, g.description, g.image, s1.arrivadDate, s1.price, s.itemId\n" +
                        "FROM goods g \n" +
                        "INNER JOIN storage s ON s.itemId = g.id \n" +
                        "INNER JOIN stockcontrolcard s1 ON s.SccId = s1.id \n" +
                        "WHERE s1.issueDate IS NULL \n"+
                        "ORDER BY s1.arrivadDate\n" +
                        ")  AS sortDate\n" +
                        "GROUP BY sortDate.itemId\n" +
                        "HAVING sortDate.id = " + id;
        ResultSet resultSet =  statement.executeQuery(SQL);


        ArrayList item = new ArrayList<>();

        while (resultSet.next()) {

            item.add(resultSet.getString("id"));
            item.add(resultSet.getString("name"));
            item.add(resultSet.getString("category"));
            item.add(resultSet.getString("image"));
            item.add(resultSet.getString("description"));
            item.add(resultSet.getString("price"));
            item.add(resultSet.getString("count"));

        }

        return item;

    }

    @GetMapping("/BookedItems")
    public ArrayList getBookedItems() throws SQLException  {
        Statement statement = connection.createStatement();
        String SQL = "SELECT s.*, g.name, storage.SccId AS SCC FROM sales s INNER JOIN goods g ON s.itemId = g.id INNER JOIN storage ON  g.id = storage.itemId WHERE s.courier IS NULL";
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
            item.add(resultSet.getString("SCC"));

            items.add(item);
        }

        return items;
    }

    @PostMapping("/register")
    public SQLException registerItem(@RequestBody RegisterItem newItem) {

        try {
            for (int i = 0; i < newItem.getCount(); i++) {

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

                SQL = "INSERT INTO storage (workerId, itemId, SccId) VALUE (?, ?, ?)";

                preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, newItem.getWorker());
                preparedStatement.setInt(2, newItem.getName());
                preparedStatement.setInt(3, insertedId);

                preparedStatement.executeUpdate();

                SQL = "INSERT INTO providerwaybills (providerId, waybillId) VALUE (?, ?)";

                preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, newItem.getProvider());
                preparedStatement.setInt(2, insertedIdWaybill);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            return e;
        }


        return null;
    }

    @PutMapping("/editGoods")
    public String editGoods(@RequestParam("category") String category,
                          @RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("id") int id,
                          @RequestParam("file") MultipartFile file) throws SQLException {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();


                String type = file.getContentType().split("/")[1];

                String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                Random rnd = new Random();
                StringBuilder sb = new StringBuilder(10);
                for (int i = 0; i < 10; i++)
                    sb.append(chars.charAt(rnd.nextInt(chars.length())));

                String rnbName = sb.toString();

                String fileName = rnbName + "." + type;

                String path = "src/main/resources/static/"+fileName;

                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path)));


                stream.write(bytes);
                stream.close();


                String SQL = "UPDATE goods SET name = ?, category = ? , image = ?, description = ? WHERE id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, category);
                preparedStatement.setString(3, fileName);
                preparedStatement.setString(4, description);
                preparedStatement.setInt(5, id);

                preparedStatement.executeUpdate();

                return fileName;
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }

    @PutMapping("/editProviders")
    public void editProviders(@RequestBody LinkedHashMap param) throws SQLException {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        for (int i = 0; i < values.size(); i++) {

            ArrayList data = values.get(i);

            String SQL = "UPDATE providers SET name = ?,  phone = ? WHERE providerId = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, (String) data.get(1));
            preparedStatement.setString(2, (String) data.get(2));
            preparedStatement.setInt(3, Integer.parseInt((String) data.get(0)));
            preparedStatement.executeUpdate();

        }
    }


    @PutMapping("/editProviderWaybills")
    public void editProviderWaybills(@RequestBody LinkedHashMap param) throws SQLException {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        for (int i = 0; i < values.size(); i++) {

            ArrayList data = values.get(i);

            String SQL = "UPDATE providerwaybills SET providerId = ?,  waybillId = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, Integer.parseInt((String) data.get(1)));
            preparedStatement.setInt(2, Integer.parseInt((String) data.get(2)));
            preparedStatement.setInt(3, Integer.parseInt((String) data.get(0)));
            preparedStatement.executeUpdate();

        }
    }

    @PutMapping("/editWorkers")
    public void editWorkers(@RequestBody LinkedHashMap param) throws SQLException {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        for (int i = 0; i < values.size(); i++) {

            ArrayList data = values.get(i);

            String SQL = "UPDATE workers SET name = ?, role = ?, birthday = ?, phone = ?, address = ?, salary = ? WHERE workerId = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, (String) data.get(1));
            preparedStatement.setString(2, (String) data.get(2));
            preparedStatement.setString(3, (String) data.get(3));
            preparedStatement.setString(4, (String) data.get(4));
            preparedStatement.setString(5, (String) data.get(5));

            if (data.get(6) instanceof Integer) {
                preparedStatement.setInt(6, (Integer) data.get(6));
            } else {
                preparedStatement.setInt(6, Integer.parseInt((String) data.get(6)));
            }

            preparedStatement.setInt(7, Integer.parseInt((String) data.get(0)));
            preparedStatement.executeUpdate();

        }
    }

    @PutMapping("/editCategories")
    public SQLException editCategories(@RequestBody LinkedHashMap param) {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        try {
            for (int i = 0; i < values.size(); i++) {

                ArrayList data = values.get(i);

                String SQL = "UPDATE categories SET name = ?, description = ? WHERE id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, (String) data.get(1));
                preparedStatement.setString(2, (String) data.get(2));
                preparedStatement.setInt(3, Integer.parseInt((String) data.get(0)));
                preparedStatement.executeUpdate();

            }
            return null;
        } catch (SQLException e) {
            return e;
        }
    }

    @PutMapping("/editSCC")
    public void editSCC(@RequestBody LinkedHashMap param) throws SQLException {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        for (int i = 0; i < values.size(); i++) {

            ArrayList data = values.get(i);

            String SQL = "UPDATE stockcontrolcard SET price = ?, arrivadDate = ?, issueDate = ?, place = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            if (data.get(1) instanceof Integer) {
                preparedStatement.setInt(1, (Integer) data.get(1));
            } else {
                preparedStatement.setInt(1, Integer.parseInt((String) data.get(1)));
            }

            preparedStatement.setString(2, (String) data.get(2));
            preparedStatement.setString(3, (String) data.get(3));
            preparedStatement.setString(4, (String) data.get(4));
            preparedStatement.setInt(5, Integer.parseInt((String) data.get(0)));
            preparedStatement.executeUpdate();

        }
    }

    @PutMapping("/editRoles")
    public SQLException editRoles(@RequestBody LinkedHashMap param) throws SQLException {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        try {
            for (int i = 0; i < values.size(); i++) {

                ArrayList data = values.get(i);

                String SQL = "UPDATE roles SET role = ?, description = ? WHERE id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, (String) data.get(1));
                preparedStatement.setString(2, (String) data.get(2));
                preparedStatement.setInt(3, Integer.parseInt((String) data.get(0)));
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            return e;
        }

        return null;
    }


    @PutMapping("/editStorage")
    public void editStorage(@RequestBody LinkedHashMap param) throws SQLException {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        for (int i = 0; i < values.size(); i++) {

            ArrayList data = values.get(i);

            String SQL = "UPDATE storage SET workerId = ?, SccId = ?, itemId = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, Integer.parseInt((String) data.get(1)));
            preparedStatement.setInt(2, Integer.parseInt((String) data.get(2)));
            preparedStatement.setInt(3, Integer.parseInt((String) data.get(3)));
            preparedStatement.setInt(4, Integer.parseInt((String) data.get(0)));
            preparedStatement.executeUpdate();

        }
    }

    @PutMapping("/editWaybills")
    public void editWaybills(@RequestBody LinkedHashMap param) throws SQLException {

        ArrayList<ArrayList> values = (ArrayList) param.get("param");

        for (int i = 0; i < values.size(); i++) {

            ArrayList data = values.get(i);

            String SQL = "UPDATE waybill SET createdDate = ?, itemId = ?, count = ?, price = ?, SccId = ?, waybillName = ?, recipientId = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, (String) data.get(1));
            preparedStatement.setInt(2, Integer.parseInt((String) data.get(2)));

            if (data.get(3) instanceof Integer) {
                preparedStatement.setInt(3, (Integer) data.get(3));
            } else {
                preparedStatement.setInt(3, Integer.parseInt((String) data.get(3)));
            }

            if (data.get(4) instanceof Integer) {
                preparedStatement.setInt(4, (Integer) data.get(4));
            } else {
                preparedStatement.setInt(4, Integer.parseInt((String) data.get(4)));
            }

            preparedStatement.setInt(5, Integer.parseInt((String) data.get(5)));
            preparedStatement.setString(6, (String) data.get(6));

            if (data.get(7) instanceof Integer) {
                preparedStatement.setInt(7, (Integer) data.get(7));
            } else {
                preparedStatement.setInt(7, Integer.parseInt((String) data.get(7)));
            }
            preparedStatement.setInt(8, Integer.parseInt((String) data.get(0)));
            preparedStatement.executeUpdate();

        }
    }


    @DeleteMapping("/delete")
    public void deleteValue(@RequestBody Delete deleteItem) throws SQLException {


        Statement statement = connection.createStatement();
        String SQL = "DELETE FROM "+deleteItem.getType()+" WHERE id = "+deleteItem.getId();
        statement.executeUpdate(SQL);


        System.out.println(deleteItem.getId() + " " + deleteItem.getType());

    }

    @PostMapping("/buyGoods")
    public Object buyGoods(@RequestBody BuyGoods buyItem) {

        String SQL = "INSERT INTO sales (itemId, dateOfSale, mailOfBuyer, count) VALUE (?, CURDATE(), ?, ?)";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, buyItem.getItemId());
            preparedStatement.setString(2, buyItem.getMailOfBuyer());
            preparedStatement.setInt(3, buyItem.getCount());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            return e;
        }
    }

    @PostMapping("/buyBasket")
    public Object buyBasket(@RequestBody LinkedHashMap param) {

        LinkedHashMap values = (LinkedHashMap) param.get("items");

        ArrayList items = (ArrayList) values.get("items");
        String mail = (String) values.get("mailOfBuyer");

        String SQL = "INSERT INTO sales (itemId, dateOfSale, mailOfBuyer, count) VALUE (?, CURDATE(), ?, ?)";

        for (int i = 0; i < items.size(); i++) {

            try {

                LinkedHashMap temp = (LinkedHashMap) items.get(i);
                
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setInt(1, Integer.parseInt((String) temp.get("id")));
                preparedStatement.setString(2, mail);
                preparedStatement.setInt(3, (Integer) temp.get("count"));

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                return e;
            }
        }
        return true;
    }

    @PostMapping("/saleGoods")
    public Object saleGoods(@RequestBody SaleGoods saleGoods) throws SQLException {

        String SQL = "START TRANSACTION;";
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL);

        try {

            for (int i = 0; i < saleGoods.getCount(); i++) {

                SQL = "SELECT sortDate.storage, sortDate.scc FROM" +
                        " (SELECT " +
                        " g.id, g.name, g.category, g.description, g.image, s1.arrivadDate, s1.price, s.itemId, s.id as storage, s1.id as scc" +
                        " FROM goods g " +
                        " INNER JOIN storage s ON s.itemId = g.id " +
                        " INNER JOIN stockcontrolcard s1 ON s.SccId = s1.id " +
                        " ORDER BY s1.arrivadDate" +
                        " )  AS sortDate" +
                        " WHERE sortDate.id = " + saleGoods.getItemId() +
                        " LIMIT 1;";

                ResultSet resultSet =  statement.executeQuery(SQL);

                String storage = "";
                String SCC = "";

                while (resultSet.next()) {

                    storage = resultSet.getString("storage");
                    SCC = resultSet.getString("scc");
                }

                if (storage.equals("") || SCC.equals("")) {
                    return 24;
                }

                statement = connection.createStatement();
                SQL = "DELETE FROM storage WHERE id = "+storage;
                statement.executeUpdate(SQL);

                statement = connection.createStatement();
                SQL = "UPDATE stockcontrolcard SET issueDate = CURDATE() WHERE id = "+SCC;
                statement.executeUpdate(SQL);

            }

            statement = connection.createStatement();
            SQL = "UPDATE sales SET courier = "+saleGoods.getCourierId()+", sccId = "+saleGoods.getSccId()+" WHERE id = "+saleGoods.getSaleId()+";";
            statement.executeUpdate(SQL);

            statement = connection.createStatement();
            SQL = "COMMIT;";
            statement.executeUpdate(SQL);

            return "commit";

        } catch (SQLException e) {

            statement = connection.createStatement();
            SQL = "ROLLBACK";
            statement.executeUpdate(SQL);

            return e;
        }

    }


    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody
    Object handleFileUpload(@RequestParam("name") String category,
                            @RequestParam("name") String name,
                            @RequestParam("name") String description,
                            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                String type[] = name.split("[.]");

                String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                Random rnd = new Random();
                StringBuilder sb = new StringBuilder(10);
                for (int i = 0; i < 10; i++)
                    sb.append(chars.charAt(rnd.nextInt(chars.length())));

                String rnbName = sb.toString();

                String fileName = type[0] + rnbName + "." + type[1];

                String path = "src/main/resources/static/"+fileName;

                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(path)));

                
                stream.write(bytes);
                stream.close();


                return "Вы удачно загрузили " + name + " в " + path + " !";
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }





}
