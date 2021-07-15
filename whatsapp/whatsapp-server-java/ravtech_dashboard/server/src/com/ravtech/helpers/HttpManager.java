package com.ravtech.helpers;

import com.ravtech.http.handlers.StaticHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpManager implements ConnectionStrategy {

    private static HttpManager ourInstance;
    private static com.sun.net.httpserver.HttpServer server = null;

    public static HttpManager getInstance(Integer port) throws Exception {
        System.out.println("port = [" + port + "]");
        if (ourInstance == null) {
            ourInstance = new HttpManager(port);
        }
        return ourInstance;
    }

    private HttpManager(Integer port) throws Exception {
        server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port), 0);
    }

//    @Override
//    public void setPort(Integer port) {
//        this.port = port;
//    }

    @Override
    public void addContext(String path, HttpHandler handler) {
        server.createContext(path).setHandler(handler);
    }

    @Override
    public void start() {

        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server run");
    }


}
