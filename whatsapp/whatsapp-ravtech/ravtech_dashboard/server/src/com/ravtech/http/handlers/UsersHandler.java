package com.ravtech.http.handlers;

import com.ravtech.FunctionsStatic;
import com.ravtech.controller.ControllerUser;
import com.ravtech.model.User.UserOfWhatsappGrup;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

import java.util.Map;

public class UsersHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {

        ControllerUser controllerUser = ControllerUser.getInstance();
        Map<String, String> result;
        String[] chack = new String[2];

        String[] query = t.getRequestURI().getPath().split("/");
        System.out.println(query[2]);


            switch (query[2]) {
                case "getuser":
                    result = FunctionsStatic.cutTheQuery(t);
                    chack = controllerUser.getUser(result.get("username"));
                    FunctionsStatic.writeResponse(t, chack[0] , Integer.parseInt(chack[1]));
                    break;


                case "addGrup":
                    UserOfWhatsappGrup group  = FunctionsStatic.parseTheBodyGenerics(t, UserOfWhatsappGrup.class);
                    if(group.isValid(group)) {
                        chack = controllerUser.addGrupName(group.getName(),group.getCreator());
                    }
                    else {
                       chack[0]= "not valid";
                        chack[1]= "300";
                    }
                    FunctionsStatic.writeResponse(t, chack[0] ,Integer.parseInt(chack[1]));
                    break;


                case "addUserToGrup":
                    UserOfWhatsappGrup.templetAddUserGrup userGrup = FunctionsStatic.parseTheBodyGenerics(t,UserOfWhatsappGrup.templetAddUserGrup.class);
                    if(userGrup.isValid(userGrup)) {
                        chack = controllerUser.addUserToGrup(userGrup.getName(),userGrup.getUserName());
                    }
                    else {
                        chack[0] = "not valid";
                        chack[1] ="300";
                    }
                    FunctionsStatic.writeResponse(t, chack[0] ,Integer.parseInt(chack[1]));
                    break;

                case "removeUserFromGrup":
                    result = FunctionsStatic.cutTheQuery(t);
                    chack = controllerUser.removeUserFromGrup(result.get("namegrup"),result.get("username"));
                    FunctionsStatic.writeResponse(t, chack[0] ,Integer.parseInt(chack[1]));
                    break;
                case "getAllUsers":
                    chack = controllerUser.getAllUsers();
                    FunctionsStatic.writeResponse(t, chack[0] ,Integer.parseInt(chack[1]));
                    break;
                case "getAllUsersByGrup":
                    result = FunctionsStatic.cutTheQuery(t);
                    chack = controllerUser.getAllUsersByGrup(result.get("name"));
                    FunctionsStatic.writeResponse(t, chack[0] ,Integer.parseInt(chack[1]));
                    break;
                case "getAllGroups":
                    System.out.println("ldllllllllll");
                    result = FunctionsStatic.cutTheQuery(t);
                    chack = controllerUser.getAllGroups(result.get("username"));
                    FunctionsStatic.writeResponse(t, chack[0] ,Integer.parseInt(chack[1]));

            }



        }
}
