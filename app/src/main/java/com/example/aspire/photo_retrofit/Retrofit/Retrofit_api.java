package com.example.aspire.photo_retrofit.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofit_api {
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=beaches&image_type=photo&pretty=true")
    Call<Retrofit_model> getbeaches();
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=mountains&image_type=photo&pretty=true")
    Call<Retrofit_model> getmountains();
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=cartoon_toys&image_type=photo&pretty=true")
    Call<Retrofit_model> getToys();
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=animals&image_type=photo&pretty=true")
    Call<Retrofit_model> getAnimal();
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=army_planes&image_type=photo&pretty=true")
    Call<Retrofit_model> getPlane();
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=flowers&image_type=photo&pretty=true")
    Call<Retrofit_model> getFlowers();
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=birds&image_type=photo&pretty=true")
    Call<Retrofit_model> getBirds();
    @GET("/api/?key=10821221-4c1d957e1f69095a0521b3c02&q=lakes&image_type=photo&pretty=true")
    Call<Retrofit_model> getLake();



}
