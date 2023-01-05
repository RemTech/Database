package com.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

 private static Connection con;

    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cls) {
            cls.getLocalizedMessage();
        }
    }

    public static Connection getDBConnection(String url,String username,String password) {

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException sqlException) {
            sqlException.getLocalizedMessage();
        }
        return con;
    }

}

