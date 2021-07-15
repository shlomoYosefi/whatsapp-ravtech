package com.ravtech;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public abstract class FunctionsStatic{

    static Gson gson = new Gson();

    public static HashMap cutTheQuery(HttpExchange httpExchange){
        String query = httpExchange.getRequestURI().getQuery();
        HashMap<String, String> result = new HashMap<>();
        if(query == null) {
            System.out.println("null");
        }
        else {
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) {
                    result.put(entry[0], entry[1]);
                } else {
                    result.put(entry[0], "");
                }
            }
        }
        return result;
    }







    public static <T> T parseTheBodyGenerics(HttpExchange httpExchange, Class<T> cls)  {
        InputStream inputStream = httpExchange.getRequestBody();
        T t = new Gson().fromJson(new InputStreamReader(inputStream), cls);
        return  t;
    }







    public static  void writeToDB(Object map,String path) throws IOException {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(path));
            gson.toJson(map, writer);
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }




        public static <E> E  readFromDBTest(String path, Class cls) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(path));
            return new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(jsonReader, cls);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }








    public static void writeResponse(HttpExchange httpExchange, String result ,int status) throws IOException {
        Headers headers = httpExchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin","*");
        result = result.replaceAll("\\[","{");
        result = result.replaceAll("\\]","}");


        httpExchange.sendResponseHeaders(status,result.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(result.getBytes());
        os.close();
    }
}
