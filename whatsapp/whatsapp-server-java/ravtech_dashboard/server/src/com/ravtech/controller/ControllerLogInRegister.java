package com.ravtech.controller;

import com.ravtech.FunctionsStatic;
import com.ravtech.RTMessenger;
import com.ravtech.model.User.UserOfWhatsapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerLogInRegister {

    UserOfWhatsapp userOfWhatsapp;
    String path ="server/src/com/ravtech/DBjson/users.json";
    Map hashMap = new HashMap();
    String result[] = new String[2];

    private static ControllerLogInRegister controllerLogInRegister = new ControllerLogInRegister();

    public static ControllerLogInRegister getInstanceLogInRegister(){
        return controllerLogInRegister;
    }


    public String[] chackUser(String userName, String password) throws IOException {
        UserOfWhatsapp.DBUserOfWhatsapp users = FunctionsStatic.readFromDBTest(path,UserOfWhatsapp.DBUserOfWhatsapp.class);
        hashMap = users.map;
        UserOfWhatsapp currentUser = (UserOfWhatsapp) hashMap.get(userName);
        if(currentUser !=null){
            if(currentUser.getPassword().equals(password)){
                this.userOfWhatsapp = currentUser;
                result[0]=currentUser.toString();
                result[1] ="200";
                return result;
            }
            else{
                result[0]="wrong password";
                result[1] ="300";
                return result;
            }

        }
        result[0]="There is no such user";
        result[1] ="500";
        return result;
    }




    public String[] register(UserOfWhatsapp userOfWhatsapp) throws IOException {
        userOfWhatsapp.setUserName();
        UserOfWhatsapp.DBUserOfWhatsapp users = FunctionsStatic.readFromDBTest(path,UserOfWhatsapp.DBUserOfWhatsapp.class);
        hashMap = users.map;
        if (hashMap.get(userOfWhatsapp.getUserName())==null) {
            users.map.put(userOfWhatsapp.getUserName(),userOfWhatsapp);
            FunctionsStatic.writeToDB(users,path);
            result[0]= "success add user";
            result[1] ="200";
            return result;
        }
        result[0]= "There is such a user";
        result[1] ="300";
        return result;
    }

}
