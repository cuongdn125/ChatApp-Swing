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
import model.Message;

public class MessDAO {
    Statement statement;
    ResultSet rs;
    DAO dao;
    PreparedStatement preStatement;
    Connection conn;
     public MessDAO() {
        
        try {
            dao = new DAO();
        
            this.conn = this.dao.getMySQLConnection();
            statement = conn.createStatement();

        } catch (SQLException e) {
                e.printStackTrace();
        }

    }
     public int insertMess(Message mess) {
         
        String sql = "INSERT INTO Message (mess,"+"type)"+"VALUES (?,?)";
        String sql1 = "INSERT INTO Message (mess,"+"type, srcUser, desUser)"+"VALUES (?,?,?,?)";
        try {
//            rs = statement.executeQuery(sql);
            
            if(mess.getDes() != null){
//                System.out.println("abcdef");
                this.preStatement = this.conn.prepareStatement(sql1);
                this.preStatement.setString(1, mess.getMessage());
                this.preStatement.setString(2, mess.getType());
                this.preStatement.setString(3, mess.getSrc());
                this.preStatement.setString(4, mess.getDes());
            }else {
                this.preStatement = this.conn.prepareStatement(sql);
                this.preStatement.setString(1, mess.getMessage());
                this.preStatement.setString(2, mess.getType());
            }

            
            
            
            int rowCount=this.preStatement.executeUpdate();

            return rowCount;


        } catch (SQLException e1) {
               e1.printStackTrace();
        }
        
        return 0;
    }
     public ArrayList<String> getMessAll(){
         String sql = "Select * from Message where Type='ChatAll'";
         ArrayList<String> list = new ArrayList<String>();
         try{
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String x = rs.getString(4) +": "+rs.getString(2);
                list.add(x);
            } 
            return list;
         } catch (SQLException e1) {
            e1.printStackTrace();
        }
         return list;
     }
    public ArrayList<String> getMessPrivate(String src, String des){
        String sql = "Select * from Message where Type='Private' and ((srcUser = '" + src +"' and desUser ='" + des +"') or ( srcUser='"+des+"' and desUser ='"+src+"'))";
        ArrayList<String> list = new ArrayList<String>();
         try{
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String x = rs.getString(4) +": "+rs.getString(2);
                list.add(x);
            } 
            return list;
         } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
        
        
    }
     public ArrayList<String> getMessGroup(String group) {
         String sql = "Select * from Message where type='Group' and desUser='" + group +"'";
         ArrayList<String> list = new ArrayList<String>();
         try{
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String m = rs.getString(4) +": "+rs.getString(2);
                list.add(m);
            } 
            return list;
         } catch (SQLException e1) {
            e1.printStackTrace();
        }
         
         
         
         return list;
     }
     
//     public ArrayList<String> getMessPrivate(String source, String des){
//         String sql = "Select * from Message where Type='Private' and ";
//         ArrayList<Message> list = new ArrayList<Message>();
//         try{
//            rs = statement.executeQuery(sql);
//            while(rs.next()){
//                Message m = new Message(rs.getString(2), rs.getString(3));
//                list.add(m);
//            } 
//            return list;
//         } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
//         return list;
//     }
}
