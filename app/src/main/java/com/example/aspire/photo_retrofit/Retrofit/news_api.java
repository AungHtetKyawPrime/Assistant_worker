package com.example.aspire.photo_retrofit.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface news_api {
    @GET("v2/everything?q=laliga&from=publishedAt&apiKey=129a336ade1d43efbecf53de7735f8fb")
    Call<news_model> getlaliga();
    @GET("v2/everything?q=manchesterunited&from=publishedAt&apiKey=129a336ade1d43efbecf53de7735f8fb")
    Call<news_model> getManu();
    @GET("v2/everything?q=football&from=publishedAt&apiKey=129a336ade1d43efbecf53de7735f8fb")
    Call<news_model> getPremier();

}
