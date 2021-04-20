/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untils;

import java.sql.*;

/**
 *
 * @author tomnyson
 */
public class DBProvider {
    private static String USER_NAME = "sa";
    private static String PASSWORD = "Admin123@";
    private static String DATABASE = "qlbh";
    private static String DB_URL = "jdbc:sqlserver://localhost;databaseName=qlbh;user=sa;password=Admin123@";
    
    
   public static Connection getSqlConnection() {
       Connection conn = null;
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("connect successfully!");
       } catch (Exception e) {
           System.out.println("connect failure!");
            e.printStackTrace();
       }
        return conn;
   }
   
      public static ResultSet getResult(String query) {
        ResultSet rs = null;
        Connection conn = getSqlConnection();
       try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            conn.close();
       } catch (Exception e) {
           System.out.println("connect failure!");
            e.printStackTrace();
       }
        return rs;
   }
   
}
