package com.example.applicationgithub.api;

import com.example.applicationgithub.model.datalist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/events")
    Call<List<datalist>> getActor();
}
