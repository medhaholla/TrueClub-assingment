package com.example.demotrueClub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBoperations {
    public static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            synchronized (DBoperations.class){
                if(connection == null){
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TrueClub","root","@Adha2621");

                }
            }
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if(connection != null){
            synchronized (DBoperations.class){
                if(connection != null) {
                    connection.close();
                }
            }
        }

    }

}

