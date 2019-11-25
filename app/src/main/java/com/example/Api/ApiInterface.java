package com.example.Api;

import com.example.mytestmap.Models.DirectionPojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("maps/api/directions/json?")
    Call<DirectionPojo> getPolyLine(@QueryMap Map<String, String> data);



}
