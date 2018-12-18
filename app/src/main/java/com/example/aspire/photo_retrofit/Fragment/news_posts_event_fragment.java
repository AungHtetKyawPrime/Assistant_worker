package com.example.aspire.photo_retrofit.Fragment;




import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Posts_view;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_api;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_model;
import com.example.aspire.photo_retrofit.Retrofit.news_api;
import com.example.aspire.photo_retrofit.Retrofit.news_data;
import com.example.aspire.photo_retrofit.Retrofit.news_model;
import com.example.aspire.photo_retrofit.Retrofit.retrofit_data;
import com.example.aspire.photo_retrofit.football_news;
import com.roger.catloadinglibrary.CatLoadingView;

import java.util.ArrayList;
import java.util.List;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class news_posts_event_fragment extends Fragment {
    CardView beach,mountain,animal,bird,flower,plane,toy,lake,football;
    public static List<Retrofit_model.photo_data> main_post;
    public static List<news_model.news> football_post=new ArrayList<>();
    List<Retrofit_model.photo_data> beach_post=new ArrayList<>();
    List<Retrofit_model.photo_data> mountain_post=new ArrayList<>();
    List<Retrofit_model.photo_data> animal_post=new ArrayList<>();
    List<Retrofit_model.photo_data> bird_post=new ArrayList<>();
    List<Retrofit_model.photo_data> lake_post=new ArrayList<>();
    List<Retrofit_model.photo_data> flight_post=new ArrayList<>();
    List<Retrofit_model.photo_data> flower_post=new ArrayList<>();
    List<Retrofit_model.photo_data> toy_post=new ArrayList<>();
    public static List<news_model.news> laliga=new ArrayList<>();
    public static List<news_model.news> manu=new ArrayList<>();
    public static List<news_model.news> premier=new ArrayList<>();
    ProgressDialog progressDialog;
    CatLoadingView mView;
    public news_posts_event_fragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_posts,container,false);

    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView = new CatLoadingView();
        mView.show(getFragmentManager(),"News And Posts");
        mView.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mView.dismiss();
            }
        }).start();
        beach = (CardView) view.findViewById(R.id.beach);
        mountain = (CardView) view.findViewById(R.id.mountain);
        animal = (CardView) view.findViewById(R.id.animal);
        bird = (CardView) view.findViewById(R.id.bird);
        flower = (CardView) view.findViewById(R.id.flower);
        plane = (CardView) view.findViewById(R.id.plane);
        toy = (CardView) view.findViewById(R.id.toy);
        lake = (CardView) view.findViewById(R.id.lake);
        football = (CardView) view.findViewById(R.id.football);
        Retrofit_api api = retrofit_data.getRetrofitInstance().create(Retrofit_api.class);
        Call<Retrofit_model> beach_call = api.getbeaches();
        beach_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model beach_model = response.body();
                beach_post = beach_model.photo_d;

                Log.d("Hello Aung ", "Beach ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        Call<Retrofit_model> mountain_call = api.getmountains();
        mountain_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model mountain_model = response.body();
                mountain_post = mountain_model.photo_d;

                Log.d("Hello Aung ", "Mountains ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        Call<Retrofit_model> toy_call = api.getToys();
        toy_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model toy_model = response.body();
                toy_post = toy_model.photo_d;

                Log.d("Hello Aung ", "toy ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        Call<Retrofit_model> flower_call = api.getFlowers();
        flower_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model flower_model = response.body();
                flower_post = flower_model.photo_d;

                Log.d("Hello Aung ", "flower ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        Call<Retrofit_model> flight_call = api.getPlane();
        flight_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model flight_model = response.body();
                flight_post = flight_model.photo_d;

                Log.d("Hello Aung ", "Plane ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        Call<Retrofit_model> bird_call = api.getBirds();
        bird_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model bird_model = response.body();
                bird_post = bird_model.photo_d;

                Log.d("Hello Aung ", "Birds ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        Call<Retrofit_model> lake_call = api.getLake();
        lake_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model lake_model = response.body();
                lake_post = lake_model.photo_d;

                Log.d("Hello Aung ", "lake ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        Call<Retrofit_model> animal_call = api.getAnimal();
        animal_call.enqueue(new Callback<Retrofit_model>() {
            @Override
            public void onResponse(Call<Retrofit_model> call, Response<Retrofit_model> response) {
                //myProgressBar.setVisibility(View.GONE);
                Retrofit_model animal_model = response.body();
                animal_post = animal_model.photo_d;

                Log.d("Hello Aung ", "animal ");
            }

            @Override
            public void onFailure(Call<Retrofit_model> call, Throwable t) {

            }
        });
        news_api news= news_data.getRetrofitInstance().create(news_api.class);
        Call<news_model> laliga_call=news.getlaliga();
        laliga_call.enqueue(new Callback<news_model>() {
            @Override
            public void onResponse(Call<news_model> call, Response<news_model> response) {
                news_model laliga_model=response.body();
                laliga=laliga_model.news_data;
                football_post.addAll(laliga);
                Log.d("Ball ","Laliga "+laliga.size());
            }

            @Override
            public void onFailure(Call<news_model> call, Throwable t) {

            }
        });
        Call<news_model> manu_call=news.getManu();
        manu_call.enqueue(new Callback<news_model>() {
            @Override
            public void onResponse(Call<news_model> call, Response<news_model> response) {
                news_model manu_model=response.body();
                manu=manu_model.news_data;
                football_post.addAll(manu);
                Log.d("Ball ","Manu "+manu.size());
            }

            @Override
            public void onFailure(Call<news_model> call, Throwable t) {

            }
        });
        Call<news_model> primier_call=news.getlaliga();
        primier_call.enqueue(new Callback<news_model>() {
            @Override
            public void onResponse(Call<news_model> call, Response<news_model> response) {
                news_model premier_model=response.body();
                premier=premier_model.news_data;
                football_post.addAll(premier);
                Log.d("Ball ","primier "+premier.size()+" + "+manu.size()+" + "+laliga.size()+" - "+football_post.size());
            }

            @Override
            public void onFailure(Call<news_model> call, Throwable t) {

            }
        });
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), football_news.class));
            }
        });
        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_post = new ArrayList<>();
                main_post = beach_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }

        });
        mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Mountain", Toast.LENGTH_SHORT).show();
                main_post = new ArrayList<>();
                main_post = mountain_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }
        });
        toy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_post = new ArrayList<>();
                main_post = toy_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }

        });
        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                main_post = new ArrayList<>();
                main_post = flower_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }
        });
        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_post = new ArrayList<>();
                main_post = flight_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }

        });
        bird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                main_post = new ArrayList<>();
                main_post = bird_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_post = new ArrayList<>();
                main_post = animal_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }

        });
        lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                main_post = new ArrayList<>();
                main_post = lake_post;
                startActivity(new Intent(getActivity(), Posts_view.class));
            }
        });

    }


}
