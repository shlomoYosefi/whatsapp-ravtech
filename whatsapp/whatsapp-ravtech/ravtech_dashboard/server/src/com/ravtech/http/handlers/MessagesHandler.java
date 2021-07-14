package com.ravtech.http.handlers;

import com.ravtech.FunctionsStatic;
import com.ravtech.controller.ControllerMessage;
import com.ravtech.controller.ControllerUser;
import com.ravtech.model.Message.MessageGrup;
import com.ravtech.model.Message.MessageSingel;
import com.ravtech.model.User.UserOfWhatsappGrup;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class MessagesHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        ControllerMessage controllerMessage = ControllerMessage.getInstance();
        Map<String, String> result;
        String[] chack= new String[2];
        String responce ="";
        int code =0;


        String[] query = httpExchange.getRequestURI().getPath().split("/");

        switch (query[2]){
            case "getMessage":
                result = FunctionsStatic.cutTheQuery(httpExchange);
                chack = controllerMessage.getMessageSingelById(result.get("messageId"));
                responce = chack[0];
                code = Integer.parseInt(chack[1]);
                FunctionsStatic.writeResponse(httpExchange, responce ,code);
                break;


            case "getAllMessageByUser":
                result = FunctionsStatic.cutTheQuery(httpExchange);
                chack = controllerMessage.getAllMessageByUserId(result.get("senderId"),result.get("userId"));
                responce = chack[0];
                code = Integer.parseInt(chack[1]);
                FunctionsStatic.writeResponse(httpExchange, responce ,code);
                break;

            case "getAllMessageOfSender":
                result = FunctionsStatic.cutTheQuery(httpExchange);
                chack = controllerMessage.getAllMessageOfSender(result.get("senderId"));
                responce = chack[0];
                code = Integer.parseInt(chack[1]);
                FunctionsStatic.writeResponse(httpExchange, responce ,code);
                break;


            case "getAllMessageOfGrup":
                System.out.println("ppp");
                result = FunctionsStatic.cutTheQuery(httpExchange);
                chack = controllerMessage.getAllMessageByGrupName(result.get("name"));
                responce = chack[0];
                code = Integer.parseInt(chack[1]);
                FunctionsStatic.writeResponse(httpExchange, responce ,code);
                break;


            case "addMessage":
                MessageSingel message  = FunctionsStatic.parseTheBodyGenerics(httpExchange, MessageSingel.class);
                if(message.isValid(message)) {
                    chack = controllerMessage.addMessageSingel(message);
                    responce = chack[0];
                    code = Integer.parseInt(chack[1]);
                }
                else {
                    responce = "not valid";
                    code = 500;
                }
                FunctionsStatic.writeResponse(httpExchange, responce,code);
                break;


            case "addMessageToGroup":
                MessageGrup messageGrup  = FunctionsStatic.parseTheBodyGenerics(httpExchange, MessageGrup.class);
                System.out.println(messageGrup);
                if(messageGrup.isValid(messageGrup)) {
                    chack = controllerMessage.addMessageGrup(messageGrup);
                    responce = chack[0];
                    code = Integer.parseInt(chack[1]);
                }
                else {
                    responce = "not valid";
                    code =500;
                }
                FunctionsStatic.writeResponse(httpExchange, responce,code);
                break;

            case "removeMessage":
                result = FunctionsStatic.cutTheQuery(httpExchange);
                chack = controllerMessage.removeMessageSingel(result.get("messageId"),result.get("senderId"), result.get("reciver"));
                responce = chack[0];
                System.out.println(responce);
                code = Integer.parseInt(chack[1]);
                FunctionsStatic.writeResponse(httpExchange, responce,code);
                break;

            case "removeMessageFromGrup":
                result = FunctionsStatic.cutTheQuery(httpExchange);
                chack = controllerMessage.removeMessageGrup(result.get("messageId"),result.get("senderId"),result.get("nameGroup"));
                responce = chack[0];
                code = Integer.parseInt(chack[1]);
                FunctionsStatic.writeResponse(httpExchange, responce,code);
                break;
        }

    }
}
