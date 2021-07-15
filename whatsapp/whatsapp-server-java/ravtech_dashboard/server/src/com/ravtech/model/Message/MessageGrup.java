package com.ravtech.model.Message;

import com.ravtech.model.User.UserOfWhatsapp;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

public class MessageGrup extends Message {

    private int id;
    private String nameGrup;
    private String nameSender;

    public void setNameGrup(String nameGrup) {
        this.nameGrup = nameGrup;
    }

    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }

    public MessageGrup(String text, Date dateTime, String senderId, File attachment, String attachmentType, String nameGrup) {
        super(text, dateTime, senderId, attachment, attachmentType);
        this.nameGrup = nameGrup;
    }

    public MessageGrup(String text, Date dateTime, String senderId, int originalMessageId, String originalMessageText ,String nameGrup) {
        super(text, dateTime, senderId, originalMessageId, originalMessageText);
        this.nameGrup = nameGrup;
    }

    public MessageGrup(String text, Date dateTime, String senderId, String nameGrup) {
        super(text, dateTime, senderId);
        this.nameGrup = nameGrup;
    }


    public int getId() {
        return id;
    }



    public String getNameGrup() {
        return nameGrup;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
        public String toString() {
            return "\"" + "message" + this.getId()+"\"" +":{" +
                    "\"" + "text" + "\"" + ":"+  "\"" +this.getText() + "\","+
                    "\"" + "date" +"\"" +":"+ "\"" + this.getDateTime() + "\","+
                    "\"" + "dateString" +"\"" +":"+ "\"" + this.getDateString() + "\","+
                    "\"" + "timeString" +"\"" +":"+ "\"" + this.getTimeString() + "\","+
                    "\"" + "nameGroup" +"\"" +":"+ "\"" + this.getNameGrup() + "\","+
                    "\"" + "senderId" +  "\""+":" +"\""+ getSenderId() + "\","+
                    "\"" + "id" + "\""+":" + "\"" +getId() + "\","+
                    "\"" + "nameSender" +  "\""+":" +"\""+ getNameSender() + "\""+
                    "}";
        }




    @Override
    public <T> boolean isValid(T t) {
        MessageGrup messageGrup = (MessageGrup)t;
        if((messageGrup.getNameGrup() !=null && messageGrup.getSenderId() !="" && messageGrup.getText()!= null))return true;
        return false;
    }



    public  static class DBMessage {
        public HashMap<String, MessageGrup> map;
    }
}
