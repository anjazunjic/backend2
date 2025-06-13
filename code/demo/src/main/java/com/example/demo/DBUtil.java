package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection open(){


        String url = "jdbc:mysql://localhost:3306/sistem_za_regrutaciju";
        String user = "root";
        String password = "MySQLPassword";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
