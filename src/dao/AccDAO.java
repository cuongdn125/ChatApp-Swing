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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Account;

public class AccDAO {
    Statement statement;
    ResultSet rs;
    DAO dao;
    PreparedStatement preStatement;
    Connection conn;
    public AccDAO() {
        
        try {
            dao = new DAO();
        
            this.conn = this.dao.getMySQLConnection();
            statement = conn.createStatement();

        } catch (SQLException e) {
                e.printStackTrace();
        }

    }

    public boolean isAcc(String name, String password) {
        Account acc = new Account();
        String sql = "Select * from Account where userName='" + name +"' and password ='" +password +"'" ;
        try{
            rs = statement.executeQuery(sql);
                int i = 0;
                while (rs.next()) {
//                    acc = new Account(rs.getInt(1),rs.getString(2),rs.getString(3));
                    acc.setUserID(rs.getInt(1));
                    acc.setUserName(rs.getString(2));
                    acc.setPassword(rs.getString(3));
                    i++;
                    System.out.println(i);
                    System.out.println(rs.getInt(1) +"   "+rs.getString(2)+"   "+ rs.getString(3));
            
                }
            if(i==0) return false; // chua ton tai ten nay
           return true;
        }catch(SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("loi ........");
//            e.printStackTrace();
            return false;
        }
    };

    public int insert(Account user) {
        String sql = "Select * from Account where userName='" + user.getUserName() +"'";
        String sql2 = "INSERT INTO Account (userName,"+"password)"+"VALUES (?,?)";
        
        try {
                        rs = statement.executeQuery(sql);
                        int i=0;
                        while(rs.next()) {
                            i++;
                        }
                        if(i==0){
                            this.preStatement = this.conn.prepareStatement(sql2);
                            this.preStatement.setString(1, user.getUserName());
                            this.preStatement.setString(2, user.getPassword());
                            int rowCount=this.preStatement.executeUpdate();

                            return rowCount;
                        }
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
			
		}
        return 0;
    }

    public void closeConnection() {
        try {
                this.conn.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}
