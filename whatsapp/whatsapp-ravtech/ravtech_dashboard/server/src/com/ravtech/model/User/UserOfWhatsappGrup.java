package com.ravtech.model.User;

import com.ravtech.interfaces.IsClassValid;

import java.util.ArrayList;
import java.util.HashMap;

public class UserOfWhatsappGrup implements IsClassValid {

    private String name;
    private  String creator;

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    private HashMap<String,UserOfWhatsapp> users = new HashMap<>();

    public UserOfWhatsappGrup(String name) {
        this.name = name;
    }


    public String addUser(UserOfWhatsapp user){
        if( users.containsKey(user.getUserName())) {
            return "There is such a user in the system";
        }
        users.put(user.getUserName(),user);
        return "success";
    }



    public String removeUser(String userName){
        this.users.remove(userName);
        return "success";
    }

    public String getName() {
        return name;
    }

    public HashMap<String, UserOfWhatsapp> getAllUsers() {
        return users;
    }

    public UserOfWhatsapp getUser(String username){
        return this.users.get(username);
    }




    @Override
    public <T> boolean isValid(T t) {
        UserOfWhatsappGrup userOfWhatsappGrup = (UserOfWhatsappGrup) t;
        if(userOfWhatsappGrup.getName() != null)return true;
        return false;
    }



    public  static class DBUserOfWhatsappGrup {
        public HashMap<String, UserOfWhatsappGrup> map;
    }


    @Override
    public String toString() {
        return "\"" + this.getName()+"\"" +":{" +
                "\"" + "name" + "\"" + ":"+  "\"" +this.getName() + "\","+
                "\"" + "creator" + "\"" + ":"+  "\"" +this.getCreator() + "\""+
                "}";
    }




    public static class templetAddUserGrup implements IsClassValid{
        String nameGrup;
        String userName;

        public templetAddUserGrup(String name, String username) {
            this.nameGrup = name;
            this.userName = username;
        }

        public String getName() {
            return nameGrup;
        }

        public String getUserName() {
            return userName;
        }

        @Override
        public <T> boolean isValid(T t) {
            UserOfWhatsappGrup.templetAddUserGrup userOfWhatsappGrup = (UserOfWhatsappGrup.templetAddUserGrup)t;
            if(userOfWhatsappGrup.getName() != null && userOfWhatsappGrup.getUserName() !=null)return true;
            return false;
        }
    }

}

