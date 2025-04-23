package src.module.conn;

import java.sql.*;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/busreservation";
    private static final String username = "root";
    private static final String password = "password";

    public static Connection getConnection() throws Exception{

        return DriverManager.getConnection(url,username,password);
    }
}