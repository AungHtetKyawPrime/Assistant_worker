package com.example.aspire.photo_retrofit.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_data {
    private static Retrofit retrofit;

    //private static final String BASE_URL = "http s://raw.githubusercontent.com/";
    //private static final String BASE_URL = "https://cdn.rawgit.com";
    private static final String BASE_URL = "https://pixabay.com";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
