package com.example.demotrueClub;

import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBoperations {
    public static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            synchronized (DBoperations.class) {
                if (connection == null) {
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TrueClub", "root", "@Adha2621");

                }
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            synchronized (DBoperations.class) {
                if (connection != null) {
                    connection = null;
                }
            }
        }
    }
    public static void createTable (String name) throws SQLException {
                getConnection();
                Statement statement = connection.createStatement();
                boolean isCreated = statement.execute("CREATE TABLE " + name + "(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), pincode INT, address VARCHAR(50), state VARCHAR(50)) ");
                closeConnection();
            }
    public static void insertRecord(CreateRequest request) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO assingment VALUES(null,?,?,?,?)");
        preparedStatement.setString(1, request.getName());
        preparedStatement.setInt(2, request.getPincode());
        preparedStatement.setString(3, request.getAddress());
        preparedStatement.setString(4, request.getState());

        int rows_affected = preparedStatement.executeUpdate();
        closeConnection();
    }
    public static List <Assignment> getRecords() throws SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM assingment");
        List<Assignment> userList = new ArrayList<>();
        while(resultSet.next()){

            String name = resultSet.getString(1);
            int pincode = resultSet.getInt(2);
            String address = resultSet.getString(3);
            String state = resultSet.getString(5);

            Assignment assignment = new Assignment(name,pincode,address,state);
            userList.add(assignment);
        }
        return userList;
    }
    public static void deleteRecord(int id) throws SQLException {
        getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM assingment WHERE id = " + id);
        statement.setInt(1,id);
        statement.executeUpdate();
        closeConnection();

    }
    public static Assignment getRecord(int id) throws SQLException {
        getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM assingment WHERE id = " + id);
        ResultSet resultSet = statement.executeQuery();
        List<Assignment> userList = new ArrayList<>();

        while(resultSet.next()){
            String name = resultSet.getString(1);
            int pincode = resultSet.getInt(2);
            String address = resultSet.getString(3);
            String state = resultSet.getString(5);


            Assignment assignment = new Assignment(name,pincode,address,state);
            userList.add(assignment);
            for(Assignment user : userList){
                if(user.getId() == id){
                    return user;
                }
            }

        }
        return null;
    }

        }



