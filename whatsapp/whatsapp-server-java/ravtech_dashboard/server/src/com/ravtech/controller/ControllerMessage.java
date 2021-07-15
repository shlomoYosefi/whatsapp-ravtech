package com.ravtech.controller;

import com.ravtech.FunctionsStatic;
import com.ravtech.RTMessenger;
import com.ravtech.model.Message.Message;
import com.ravtech.model.Message.MessageGrup;
import com.ravtech.model.Message.MessageSingel;
import com.ravtech.model.User.UserOfWhatsapp;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class ControllerMessage {


    String pathOfMessage="server/src/com/ravtech/DBjson/message.json";
    String pathOfMessageGrup="server/src/com/ravtech/DBjson/messagesGrup.json";
    String pathUsers ="server/src/com/ravtech/DBjson/users.json";

    String[] result =new String[2];
    String codeSuccess = "200";
    String codeErorr ="400";
    String codeNotValid ="500";

    private  static  ControllerMessage controllerMessage = new ControllerMessage();


    public static ControllerMessage getInstance(){
        return controllerMessage;
    }


    private ControllerMessage() {
    }


    public String[] addMessageSingel(MessageSingel message) throws IOException {
        try {
            Date date = new Date();
            LocalTime localTime = LocalTime.now();
            LocalDate localDate = LocalDate.now();

            UserOfWhatsapp.DBUserOfWhatsapp users = FunctionsStatic.readFromDBTest(pathUsers,UserOfWhatsapp.DBUserOfWhatsapp.class);
            message.setReceiverName(users.map.get(message.getReceiverId()).getName() +"  " + users.map.get(message.getReceiverId()).getLastName());
            message.setSenderName(users.map.get(message.getSenderId()).getName() +"  " + users.map.get(message.getSenderId()).getLastName());

            message.setDateTime(date);
            message.setDateString(localDate);
            message.setTimeStyring(localTime);
            MessageSingel.DBMessage messages = FunctionsStatic.readFromDBTest(pathOfMessage,MessageSingel.DBMessage.class);
            List<MessageSingel> arrMessage = new ArrayList<MessageSingel>(messages.map.values());
            int id = arrMessage.size()>0?arrMessage.get(0).getId()+1:1;
            message.setId(id);
            messages.map.put("message"+message.getId(),message);
            FunctionsStatic.writeToDB(messages,pathOfMessage);
            System.out.println(arrMessage.get(0).getId());
            System.out.println(id);
            return this.getAllMessageByUserId(message.getSenderId(),message.getReceiverId());

        } catch (IOException e) {
            result[0] = e.toString();
            result[1] = codeErorr;
            return result;
        }
    }
    public String[] addMessageGrup( MessageGrup messageGrup) throws IOException {
        try {
            Date date = new Date();
            LocalTime localTime = LocalTime.now();
            LocalDate localDate = LocalDate.now();
            messageGrup.setDateTime(date);
            messageGrup.setDateString(localDate);
            messageGrup.setTimeStyring(localTime);
            UserOfWhatsapp.DBUserOfWhatsapp users = FunctionsStatic.readFromDBTest(pathUsers,UserOfWhatsapp.DBUserOfWhatsapp.class);
            messageGrup.setNameSender(users.map.get(messageGrup.getSenderId()).getName() +"  " + users.map.get(messageGrup.getSenderId()).getLastName());
            MessageGrup.DBMessage msgGrup = FunctionsStatic.readFromDBTest(pathOfMessageGrup,MessageGrup.DBMessage.class);

            List<MessageGrup> arrMessage = new ArrayList<MessageGrup>(msgGrup.map.values());
            int id = arrMessage.size()>0?arrMessage.get(0).getId()+1:1;
            messageGrup.setId(id);
            msgGrup.map.put(messageGrup.getId()+"",messageGrup);
            FunctionsStatic.writeToDB(msgGrup,pathOfMessageGrup);

            return getAllMessageByGrupName(messageGrup.getNameGrup());
        } catch (IOException e) {
            result[0]=e.toString();
            result[1]=codeErorr;
            return  result;
        }

    }

    public String[] removeMessageSingel(String idMessage ,String idSender ,String reciver) throws IOException {
        MessageSingel.DBMessage messages = FunctionsStatic.readFromDBTest(pathOfMessage,MessageSingel.DBMessage.class);
        if(idSender.equals(messages.map.get(idMessage).getSenderId())){
            messages.map.remove(idMessage);
            FunctionsStatic.writeToDB(messages,pathOfMessage);
            return  getAllMessageByUserId(idSender,reciver);
        }
        result[0]="you not sender id ";
        result[1]=codeNotValid;
         return result;
    }

    public String[] removeMessageGrup(String idMessage, String idSender,String nameGroup) throws IOException {

        MessageGrup.DBMessage msgGrup = FunctionsStatic.readFromDBTest(pathOfMessageGrup,MessageGrup.DBMessage.class);
        if(msgGrup.map.get(idMessage).getSenderId().equals(idSender)){
            msgGrup.map.remove(idMessage);
            FunctionsStatic.writeToDB(msgGrup,pathOfMessageGrup);
            return getAllMessageByGrupName(nameGroup);
        }
        result[0]="you not sender id ";
        result[1]=codeNotValid;
         return result;
    }

    public String[] getMessageSingelById(String id) throws IOException {
        MessageSingel.DBMessage messages = FunctionsStatic.readFromDBTest(pathOfMessage,MessageSingel.DBMessage.class);
        result[0]=messages.map.get(id).toString();
        result[1]=codeSuccess;
        return  result;
        }


    public String[] getAllMessageOfSender(String senderId) throws IOException {

        MessageSingel.DBMessage messages = FunctionsStatic.readFromDBTest(pathOfMessage,MessageSingel.DBMessage.class);
        result[0]=messages.map.values().stream().filter(m-> m.getSenderId().equals(senderId) || m.getReceiverId().equals(senderId)).collect(Collectors.toList()).toString();
        result[1] ="200";
        return result ;

    }


    public String[] getAllMessageByUserId(String idCurrentUser , String userId) throws IOException {
        MessageSingel.DBMessage messages = FunctionsStatic.readFromDBTest(pathOfMessage,MessageSingel.DBMessage.class);
        result[0]=messages.map.values().stream().filter(m-> (m.getSenderId().equals(idCurrentUser) && m.getReceiverId().equals(userId)) || (m.getReceiverId().equals(idCurrentUser) && m.getSenderId().equals(userId))).collect(Collectors.toList()).toString() ;
        result[1]=codeSuccess;

        return  result;
    }


    public String[] getAllMessageByGrupName(String name) throws IOException {
        MessageGrup.DBMessage msgGrup = FunctionsStatic.readFromDBTest(pathOfMessageGrup,MessageGrup.DBMessage.class);
        result[0]=msgGrup.map.values().stream().filter(m-> m.getNameGrup().equals(name)).collect(Collectors.toList()).toString();
        result[1] ="200";
        return result ;
    }



}
