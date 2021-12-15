/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GroupDAO;
import java.util.ArrayList;
import model.Group;
import model.User;

/**
 *
 * @author dangngoccuong
 */
public class GroupController {
     GroupDAO dao;
    
  public GroupController() {
      dao = new GroupDAO(); 
  }
  public void insertGroup(Group group, String user) {
      
      this.dao.insertGroup(group);
      this.dao.addUserGroup(group, user);
  }
  public void addUser(Group group, String user) {
      this.dao.addUserGroup(group, user);
  }
  public ArrayList<String> getGroup(String user){
      return this.dao.getGroupAll(user);
  }
  public ArrayList<String> getUserGroup(String groupName){
      return this.dao.getUserGroup(groupName);
  }
}
