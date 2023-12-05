package service;


import java.sql.*;

public class DbConnect {

    static String url = "jdbc:sqlserver://;serverName=localhost;databaseName=hanoi_style_du_lieu;encrypt=true;trustServerCertificate=true";
    static  String username = "sa3";
    static String password = "1";
    
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }
    
    
    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
