/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_hanoistyle;


import java.sql.*;

/**
 *
 * @author Dell
 */
public class DBConnect {
     static String url = "jdbc:sqlserver://;serverName=Dell;databaseName=xuong";
   static String username = "sa";
   static String password = "06112004";
   public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(url,username,password);
   }
    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}