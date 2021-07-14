package com.ravtech;

import com.ravtech.controller.ControllerLogInRegister;
import com.ravtech.controller.ControllerMessage;
import com.ravtech.controller.ControllerUser;
//import com.ravtech.helpers.Jwt;
import com.ravtech.http.handlers.*;
import com.ravtech.model.Message.Message;
import com.ravtech.model.Message.MessageGrup;
import com.ravtech.model.Message.MessageSingel;
import com.ravtech.model.User.User;
import com.ravtech.helpers.HttpManager;
import com.ravtech.model.User.UserOfWhatsapp;
import com.ravtech.model.User.UserOfWhatsappGrup;
import org.json.JSONObject;

import java.util.*;

public class RTMessenger {



    enum  urlsUsers  {
        GET_USER,
        ADD_GRUP,
        ADD_USER_TO_GRUP,
       REMOVE_USER_FROM_GRUP,
        GET_ALL_USERS,
        GET_ALL_USERS_BY_GRUP,
        GET_ALL_GROUPS

    }



    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
//        String token = Jwt.createToken("shlomo","a@gmail.com","0504180086");
      //  System.out.println();


//        while (true){
//            System.out.println("להוספת משתמש הקש 1" + "\n" +
//                    "להוספת הודעה הקש 2" + "\n" +
//                    "למחיקת הודעה הקש 3" + "\n" +
//                    "לקבלת הודעה לפי id הקש 4" + "\n" +
//                    "לקבלת כל ההודעות לפי id  הקש 5" + "\n" +
//                    "להדפסת כל ההודעות הקש 6" + "\n" +
//                    "להדפסת כל המשתמשים הקש 7" + "\n"
//            );
//            String firstChoice = scanner.nextLine();
//            switch (firstChoice){
//                case "1":
//                    System.out.println("לא זמין");
//                    break;
//                case "2":
//                    System.out.println("לא זמין");
//                    break;
//                case "3":
//                    System.out.println("הקש id של ההודעה שברצונך למחוק");
//                    String selectDelete = scanner.nextLine();
//                    controllerMessage.removeMessage(Integer.parseInt(selectDelete));
//                    break;
//                case "4":
//                    System.out.println("הקש id של ההודעה שברצונך לקבל");
//                    String selectGetMessage = scanner.nextLine();
//                    System.out.println(controllerMessage.getMessageById(Integer.parseInt(selectGetMessage)));
//                    break;
//                case "5":
//                    System.out.println("הקש id של משתמש שברצונך לקבל את כל ההודעות");
//                    String selectGetAllMessage = scanner.nextLine();
//                    System.out.println(controllerMessage.getAllMessageByUserId(Integer.parseInt(selectGetAllMessage),1));
//                    break;
//                case "6":
//                    for (Message message:messages.values()){
//                        System.out.println(message.toString());
//                    }
//                    break;
//                case "7":
//                    for (User user:users.values()){
//                        System.out.println(user.toString());
//                    }
//                    break;
//            }
//        }














        setConnections();
    }

    public static void setConnections() throws Exception {

        HttpManager httpManager = HttpManager.getInstance(82);
        httpManager.addContext("/home", new StaticHandler());
        httpManager.addContext("/logIn", new LogInHandler());
        httpManager.addContext("/register", new RegisterHandler());
        httpManager.addContext("/users", new UsersHandler());
        httpManager.addContext("/messages", new MessagesHandler());
        //HashMap<>



        httpManager.start();
    }
}
