package com.ravtech.model.Message;

import com.ravtech.interfaces.IsClassValid;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public abstract class Message implements IsClassValid {


   private  String text;
   private Date dateTime;
   private LocalTime timeString;
   private LocalDate dateString;

    public LocalTime getTimeString() {
        return timeString;
    }

    public void setTimeStyring(LocalTime timeString) {
        this.timeString = timeString;
    }

    public LocalDate getDateString() {
        return dateString;
    }

    public void setDateString(LocalDate dateString) {
        this.dateString = dateString;
    }

    private  String senderId;
   private int originalMessageId;
   private String originalMessageText;
    private File attachment;
    private String attachmentType;


    public Message(String text, Date dateTime, String senderId, File attachment, String attachmentType) {
        this.text = text;
        this.dateTime = dateTime;
        this.senderId = senderId;
        this.attachment = attachment;
        this.attachmentType = attachmentType;
    }

    public Message(String text, Date dateTime, String senderId, int originalMessageId, String originalMessageText) {
        this.text = text;
        this.dateTime = dateTime;
        this.senderId = senderId;
        this.originalMessageId = originalMessageId;
        this.originalMessageText = originalMessageText;

    }

    public Message(String text, Date dateTime, String senderId) {
        this.text = text;
        this.dateTime = dateTime;
        this.senderId = senderId;
    }

    public File getAttachment() {
        return attachment;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public String getText() {
        return text;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getSenderId() {
        return senderId;
    }


    public int getOriginalMessageId() {
        return originalMessageId;
    }

    public String getOriginalMessageText() {
        return originalMessageText;
    }



    @Override
    public String toString() {
        return "Message{" +
                ", text='" + text + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", senderId=" + senderId +

                '}';
    }
}
