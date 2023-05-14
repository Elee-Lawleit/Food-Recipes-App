package com.example.project.controllers;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignInController {
    //declaring JSON type constant for okHttp
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    //declaring http client
    final OkHttpClient client = new OkHttpClient();

    //method that will actually post the data, can also defined a get function
    public String post(String url, String json) throws IOException {
        //preparing request body
        RequestBody body = RequestBody.create(json, JSON);

        //building the request and appending request body
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    public String buildJson(String username, String password) {
        return "{" +
                " \"username\" : \"" + username + "\"," +
                " \"password\": \"" + password + "\"" +
                "}";
    }
}