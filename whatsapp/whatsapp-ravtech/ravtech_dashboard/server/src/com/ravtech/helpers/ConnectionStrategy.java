package com.ravtech.helpers;

import com.sun.net.httpserver.HttpHandler;

public interface ConnectionStrategy {

//    public void setPort(Integer port);
    //TODO change to same interface to match for all connections handlers
    public void addContext(String path, HttpHandler handler);
    public void start();

}
