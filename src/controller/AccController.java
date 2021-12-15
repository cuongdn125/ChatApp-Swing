/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccDAO;
import model.Account;
import java.sql.SQLException;
/**
 *
 * @author dangngoccuong
 */
public class AccController {
    AccDAO dao;
    
  public AccController() {
      dao = new AccDAO(); // TODO Auto-generated catch block
    }
  public int insert(Account e) {
        return this.dao.insert(e);
    }
  
  public boolean checkAcc(String name, String password){
      return this.dao.isAcc(name, password);
  }
}
