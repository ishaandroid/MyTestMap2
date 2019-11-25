package com.example.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static final String BASE_URL_DIRECTION = "https://maps.googleapis.com/";

    private static Retrofit retrofit1 = null;

    public static Retrofit getDirectionClient() {

        if (retrofit1 == null) {
            retrofit1 = new Retrofit.Builder().baseUrl(BASE_URL_DIRECTION)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit1;
    }
}
