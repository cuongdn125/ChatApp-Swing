/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author dangngoccuong
 */
public class User_Group {
    private Group group;
    private ArrayList<User> list;

    public User_Group() {
    }

    public User_Group(Group group, ArrayList<User> list) {
        this.group = group;
        this.list = list;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }
    
    
}
