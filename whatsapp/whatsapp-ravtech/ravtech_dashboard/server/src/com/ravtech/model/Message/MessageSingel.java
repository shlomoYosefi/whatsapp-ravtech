package com.ravtech.model.Message;

import com.ravtech.FunctionsStatic;
import com.ravtech.model.User.UserOfWhatsapp;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class MessageSingel extends Message {

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    private static int countMessages =0;
    private int id;
    private String receiverId;
    private String receiverName;
    private String senderName;


    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public MessageSingel(String text, Date dateTime, String senderId, File attachment, String attachmentType, String receiverId) {
        super(text, dateTime, senderId, attachment, attachmentType);
        this.id = ++countMessages;
        this.receiverId = receiverId;
    }

    public MessageSingel(String text, Date dateTime, String senderId, int originalMessageId, String originalMessageText ,String receiverId) {
        super(text, dateTime, senderId, originalMessageId, originalMessageText);
        this.id = ++countMessages;
        this.receiverId = receiverId;

    }

    public MessageSingel(String text, Date dateTime, String senderId, String receiverId) {
        super(text, dateTime, senderId);
        this.id = ++countMessages;
        this.receiverId = receiverId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getReceiverId() {
        return receiverId;
    }



    @Override
    public <T> boolean isValid(T t) {
        MessageSingel messageSingel = (MessageSingel)t;
        if(messageSingel.getSenderId()!="" && messageSingel.getReceiverId() !="" && messageSingel.getText()!=null) return true;
        return false;
    }

    @Override
    public String toString() {
        return "\"" + "message" + this.getId()+"\"" +":{" +
                "\"" + "text" + "\"" + ":"+  "\"" +this.getText() + "\","+
                "\"" + "date" +"\"" +":"+ "\"" + this.getDateTime() + "\","+
                "\"" + "dateString" +"\"" +":"+ "\"" + this.getDateString() + "\","+
                "\"" + "timeString" +"\"" +":"+ "\"" + this.getTimeString() + "\","+
                "\"" + "reciverName" +"\"" +":"+ "\"" + this.getReceiverName() + "\","+
                "\"" + "senderName" +"\"" +":"+ "\"" + this.getSenderName() + "\","+
                "\"" + "senderId" +  "\""+":" +"\""+ getSenderId() + "\","+
                "\"" + "id" + "\""+":" + "\"" +id + "\","+
                "\"" + "receiverId" + "\""+":" + "\"" + receiverId + "\""+
                "}";
        }

    public  static class DBMessage {
        public HashMap<String, MessageSingel> map;
    }
}
