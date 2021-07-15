package com.ravtech.http.handlers;

import com.ravtech.FunctionsStatic;
import com.ravtech.controller.ControllerLogInRegister;
import com.ravtech.model.User.UserOfWhatsapp;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class LogInHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        Map<String, String> result = FunctionsStatic.cutTheQuery(httpExchange);
        String[] chack = ControllerLogInRegister.getInstanceLogInRegister().chackUser(result.get("username"),result.get("password"));
        String response = chack[0];
        int code = Integer.parseInt(chack[1]);
        FunctionsStatic.writeResponse(httpExchange,response,code);


    }
}
