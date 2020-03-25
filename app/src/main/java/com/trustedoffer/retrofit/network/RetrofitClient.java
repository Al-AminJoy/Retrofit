package com.trustedoffer.retrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // public static String BASE_URL="http://services.hanselandpetal.com/";
    public static String BASE_URL = "https://api.myjson.com/";
    public static Retrofit retrofit;

    public static Retrofit getRetrofitClient() {
        if (retrofit != null) {
            return retrofit;
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
