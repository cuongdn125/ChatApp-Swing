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
import java.util.ArrayList;
import model.Group;
import model.User;

public class GroupDAO {
    Statement statement;
    ResultSet rs;
    DAO dao;
    PreparedStatement preStatement;
    Connection conn;
     public GroupDAO() {
        
        try {
            dao = new DAO();
        
            this.conn = this.dao.getMySQLConnection();
            statement = conn.createStatement();

        } catch (SQLException e) {
                e.printStackTrace();
        }

    }
     public int insertGroup(Group group) {
         
       String sql1 = "Select * from Group_Chat where name='" + group.getGroupName() +"'";
        String sql2 = "INSERT INTO Group_Chat (name)"+"VALUES (?)";
        
        try {
                        rs = statement.executeQuery(sql1);
                        int i=0;
                        while(rs.next()) {
                            i++;
                        }
                        if(i==0){
                            this.preStatement = this.conn.prepareStatement(sql2);
                            this.preStatement.setString(1, group.getGroupName());
                            int rowCount=this.preStatement.executeUpdate();

                            return rowCount;
                        }
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
        return 0;
    }
     public int addUserGroup(Group group, String user) {
         String sql = "INSERT INTO User_Group (userName, groupName)"+"VALUES (?,?)";
         try {

            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, user);
            this.preStatement.setString(2, group.getGroupName());
            int rowCount=this.preStatement.executeUpdate();

            return rowCount;


        } catch (SQLException e1) {
                e1.printStackTrace();

        }
        return 0;
     }
     public ArrayList<String> getUserGroup(String groupName) {
         String sql = "Select * from User_Group where groupName ='"+groupName+"'";
         ArrayList<String> list = new ArrayList<String>();
         try{
            rs = statement.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString(2));
            } 
            return list;
         } catch (SQLException e1) {
            e1.printStackTrace();
        }
         return list;
     }
     public ArrayList<String> getGroupAll(String user){
         String sql = "Select * from User_Group where userName ='"+user+"'";
         ArrayList<String> list = new ArrayList<String>();
         try{
            rs = statement.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString(3));
            } 
             
            return list;
         } catch (SQLException e1) {
            e1.printStackTrace();
        }
         return list;
     }
    
}
