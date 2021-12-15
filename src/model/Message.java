/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dangngoccuong
 */
public class Message {
    private int id;
    private String mess;
    private String type;
    private String src;
    private String des;

    public Message() {
    }

    public Message(String message, String type) {
        this.mess = message;
        this.type = type;
    }
    public Message(String message, String type, String des, String src) {
        this.mess = message;
        this.type = type;
        this.des = des;
        this.src = src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return mess;
    }

    public void setMessage(String message) {
        this.mess = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String source) {
        this.src = source;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    

}
