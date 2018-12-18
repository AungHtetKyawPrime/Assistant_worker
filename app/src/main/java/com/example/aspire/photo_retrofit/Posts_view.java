package com.example.aspire.photo_retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Fragment.news_posts_event_fragment;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_api;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_model;
import com.example.aspire.photo_retrofit.Retrofit.retrofit_data;
import com.example.aspire.photo_retrofit.adapter.post_Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Posts_view extends AppCompatActivity {
    RecyclerView post_view;post_Adapter post_adapter;
    List<Retrofit_model.photo_data> data_post=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_view);
        post_view=(RecyclerView)findViewById(R.id.post_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        post_view.setHasFixedSize(true);
        post_view.setLayoutManager(linearLayoutManager);
        data_post= news_posts_event_fragment.main_post;
        if (data_post.size()>0){
        post_adapter=new post_Adapter(getApplicationContext(),data_post);}
        else {
            Toast.makeText(this, "Please Try Again or check internet", Toast.LENGTH_SHORT).show();
        }
        post_view.setAdapter(post_adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Post view", Toast.LENGTH_SHORT).show();
    }
}
