/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author dangngoccuong
 */

import dao.MessDAO;
import model.Message;
//import java.sql.SQLException;
import java.util.ArrayList;

public class MessController {
    private MessDAO dao;
    
    public MessController(){
        dao = new MessDAO();
    }
    public int insertMess(Message mess) {
        return this.dao.insertMess(mess);
    }
    public ArrayList<String> getMessAll(){
        return this.dao.getMessAll();
    }
     public ArrayList<String> getMessPri(String src, String des){
        return this.dao.getMessPrivate(src, des);
    }
     public ArrayList<String> getMessGroup(String group){
         return this.dao.getMessGroup(group);
     }
}
