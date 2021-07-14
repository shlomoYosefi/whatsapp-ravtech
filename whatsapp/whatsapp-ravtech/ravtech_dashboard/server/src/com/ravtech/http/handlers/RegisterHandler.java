package com.ravtech.http.handlers;

import com.ravtech.FunctionsStatic;
import com.ravtech.RTMessenger;
import com.ravtech.controller.ControllerLogInRegister;
import com.ravtech.controller.ControllerUser;
import com.ravtech.model.User.UserOfWhatsapp;
import com.ravtech.model.User.UserOfWhatsappGrup;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;


public class RegisterHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        ControllerLogInRegister controllerLogInRegister = ControllerLogInRegister.getInstanceLogInRegister();
        String[] result = new String[2];
        String responce ="";
        String code ="0";

        UserOfWhatsapp userOfWhatsapp = FunctionsStatic.parseTheBodyGenerics(httpExchange, UserOfWhatsapp.class);
        if(userOfWhatsapp.isValid(userOfWhatsapp)) {
            result = controllerLogInRegister.register(userOfWhatsapp);
            responce = result[0];
            code = result[1];
        }
        else {
            responce = "not valid";
            code="500";
        }

        FunctionsStatic.writeResponse(httpExchange,responce,Integer.parseInt(code));
    }
}
