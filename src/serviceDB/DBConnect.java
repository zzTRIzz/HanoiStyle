/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceDB;


import java.sql.*;

/**
 *
 * @author Dell
 */
public class DBConnect {
     static String url = "jdbc:sqlserver://;serverName=localhost;databaseName=ASM_SOF203";
   static String username = "linh";
   static String password = "tuanlinh123";
   public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(url,username,password);
   }
    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
