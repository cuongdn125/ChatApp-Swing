/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author dangngoccuong
 */

//import static dao.ConnectMysqlExample.getConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class DAO {
    private static String DB_URL = "jdbc:mysql://localhost:3306/app_chat";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    
    
    public static Connection getMySQLConnection() {
        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
//            Statement stmt = conn.createStatement();
            // get data from table 'student'
//            ResultSet rs = stmt.executeQuery("select * from Account");
            // show data
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
//                        + "  " + rs.getString(3));
//            }
            // close connection
//            conn.close();
                return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}


