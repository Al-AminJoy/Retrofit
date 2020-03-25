package com.trustedoffer.retrofit.network;

import com.trustedoffer.retrofit.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MostWicketServiceAPI {
    //This Get Is For Flower LIst
    //@GET("feeds/flowers.json")
    //This Get Is For Player List
    @GET("bins/p8t1z")
    Call<ModelClass> getData();
}
