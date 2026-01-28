package com.rbac.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/rbac_db",
                "root",
                "Root@123"
            );
        } catch (Exception e) {

        	System.out.print(e.getMessage());
        }
        return null;
    }
}
