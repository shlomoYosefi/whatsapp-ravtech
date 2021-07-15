package com.ravtech.http.handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

public class StaticHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {


        System.out.println("t = [" + t + "]");
        URI uri = t.getRequestURI();
        String path = uri.getPath();
        URL url = getClass().getResource("index.html");
        File file = new File(url.getPath());

        if (!file.isFile()) {
            // Object does not exist or is not a file: reject with 404 error.
            String response = "404 (Not Found)\n";
            t.sendResponseHeaders(404, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            // Object exists and is a file: accept with response code 200.
            String mime = "text/html";
            if (path.substring(path.length() - 3).equals(".js")) mime = "application/javascript";
            if (path.substring(path.length() - 3).equals("css")) mime = "text/css";

            Headers h = t.getResponseHeaders();
            h.set("Content-Type", mime);
            t.sendResponseHeaders(200, 0);






            OutputStream os = t.getResponseBody();
            FileInputStream fs = new FileInputStream(file);
            final byte[] buffer = new byte[0x10000];
            int count = 0;
            while ((count = fs.read(buffer)) >= 0) {
                os.write(buffer, 0, count);
            }
            fs.close();
            os.close();

        }
    }
}
