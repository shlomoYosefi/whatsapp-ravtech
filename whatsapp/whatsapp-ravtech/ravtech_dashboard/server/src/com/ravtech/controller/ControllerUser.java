package com.ravtech.controller;

import com.google.gson.GsonBuilder;
import com.ravtech.FunctionsStatic;
import com.ravtech.RTMessenger;
import com.ravtech.model.User.UserOfWhatsapp;
import com.ravtech.model.User.UserOfWhatsappGrup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//import static com.ravtech.FunctionsStatic.readFromDB;

public class ControllerUser {

    private  static  ControllerUser controllerUser = new ControllerUser();
    public static ControllerUser getInstance(){
        return controllerUser;
    }

    String pathOfGrup="server/src/com/ravtech/DBjson/grups.json";
    String pathUsers ="server/src/com/ravtech/DBjson/users.json";
    String[] result = new String[2];




    private ControllerUser() {
    }




    public String[] getUser(String userName) throws IOException {
        UserOfWhatsapp.DBUserOfWhatsapp users = FunctionsStatic.readFromDBTest(pathUsers,UserOfWhatsapp.DBUserOfWhatsapp.class);
        result[0]= users.map.get(userName).toString();
        result[1]= "200";
        return result;
    }








    public String[] addGrupName(String name,String creator ) throws IOException {
        UserOfWhatsappGrup.DBUserOfWhatsappGrup dbGrup  = FunctionsStatic.readFromDBTest(pathOfGrup, UserOfWhatsappGrup.DBUserOfWhatsappGrup.class);
        UserOfWhatsappGrup grup = dbGrup.map.get(name);

        if(grup ==null) {
            UserOfWhatsappGrup userOfWhatsappGrup = new UserOfWhatsappGrup(name);
            UserOfWhatsapp.DBUserOfWhatsapp  users = FunctionsStatic.readFromDBTest(pathUsers, UserOfWhatsapp.DBUserOfWhatsapp.class);
            userOfWhatsappGrup.setCreator(creator);
            userOfWhatsappGrup.addUser(users.map.get(creator));

            dbGrup.map.put(name, userOfWhatsappGrup);
            FunctionsStatic.writeToDB(dbGrup, pathOfGrup);
            result[0]= "success";
            result[1]= "200";
            return result;
        }
        result[0]= "There is such a group name";
        result[1]= "350";
        return result;
    }



    public String[] addUserToGrup(String namegrup, String username) throws IOException {

        UserOfWhatsappGrup.DBUserOfWhatsappGrup  groups = FunctionsStatic.readFromDBTest(pathOfGrup, UserOfWhatsappGrup.DBUserOfWhatsappGrup.class);
        UserOfWhatsapp.DBUserOfWhatsapp  users = FunctionsStatic.readFromDBTest(pathUsers, UserOfWhatsapp.DBUserOfWhatsapp.class);
        groups.map.get(namegrup).addUser(users.map.get(username));
        FunctionsStatic.writeToDB(groups , pathOfGrup);
        result[0]= "success";
        result[1]= "200";
        return result;
    }


    public String[] removeUserFromGrup(String nameGrup,String userName) throws IOException {
        UserOfWhatsappGrup.DBUserOfWhatsappGrup groups = FunctionsStatic.readFromDBTest(pathOfGrup,UserOfWhatsappGrup.DBUserOfWhatsappGrup.class);
        groups.map.get(nameGrup).removeUser(userName);
        FunctionsStatic.writeToDB(groups , pathOfGrup);
        result[0]= "success";
        result[1]= "200";
        return  result;
    }

    public String[] getAllUsers() throws IOException {
        UserOfWhatsapp.DBUserOfWhatsapp users = FunctionsStatic.readFromDBTest(pathUsers,UserOfWhatsapp.DBUserOfWhatsapp.class);
        result[0] = users.map.values().toString();
        System.out.println(result[0]);

        result[1]= "200";
        return result;
    }

    public String[] getAllGroups(String currentUser)throws IOException{
        UserOfWhatsappGrup.DBUserOfWhatsappGrup userOfWhatsappGrup = FunctionsStatic.readFromDBTest(pathOfGrup,UserOfWhatsappGrup.DBUserOfWhatsappGrup.class);
        result[0] = userOfWhatsappGrup.map.values().stream().filter(m-> (m.getAllUsers().get(currentUser)!= null)).collect(Collectors.toList()).toString();
        result[1]= "200";
        return result;
    }


    public String[] getAllUsersByGrup(String name) throws IOException {
        UserOfWhatsappGrup.DBUserOfWhatsappGrup groups = FunctionsStatic.readFromDBTest(pathOfGrup,UserOfWhatsappGrup.DBUserOfWhatsappGrup.class);
        result[0] = groups.map.get(name).getAllUsers().toString();
        result[1]= "200";
        return result;
    }




}
