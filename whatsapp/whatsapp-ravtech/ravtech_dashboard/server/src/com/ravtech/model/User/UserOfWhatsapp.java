package com.ravtech.model.User;

import com.ravtech.model.Message.MessageSingel;

import java.util.HashMap;

public class UserOfWhatsapp extends User {


    private String name;
    private String lastName;
    private String email;
    private String phone;
//    private HashMap<String,HashMap<String, MessageSingel>> mesages;





    public UserOfWhatsapp( String name, String lastName, String email,String phone ,String password) {
        super(email, password);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void  setUserName(){
        this.setUserName(this.email);
    }

    @Override
    public String toString() {
        return "\"" + this.getUserName()+"\"" +":{" +
                "\"" + "name" + "\"" + ":"+  "\"" +this.getName() + "\","+
                "\"" + "lastname" + "\"" + ":"+  "\"" +this.getLastName() + "\","+
                "\"" + "email" + "\"" + ":"+  "\"" +this.getEmail() + "\","+
                "\"" + "phone" + "\"" + ":"+  "\"" +this.getPhone() + "\"" +
                "}";
    }

    @Override
    public <T> boolean isValid(T t) {
        UserOfWhatsapp userOfWhatsapp = (UserOfWhatsapp) t;
        if(userOfWhatsapp.getName() !=null && userOfWhatsapp.getLastName() !=null && userOfWhatsapp.getEmail() !=null && userOfWhatsapp.getPhone() != null && userOfWhatsapp.getPassword() !=null)return true;
        return false;
    }


    public  static class DBUserOfWhatsapp {
        public HashMap<String, UserOfWhatsapp> map;
    }
}
