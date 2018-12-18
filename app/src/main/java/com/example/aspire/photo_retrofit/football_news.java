package com.example.aspire.photo_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Fragment.news_posts_event_fragment;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_model;
import com.example.aspire.photo_retrofit.Retrofit.news_model;
import com.example.aspire.photo_retrofit.adapter.news_adapter;
import com.example.aspire.photo_retrofit.adapter.post_Adapter;

import java.util.ArrayList;
import java.util.List;

public class football_news extends AppCompatActivity {
    RecyclerView news_view;news_adapter news_adapter;
    List<news_model.news> news_post=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_news);
        news_view=(RecyclerView)findViewById(R.id.news_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        news_view.setHasFixedSize(true);
        news_view.setLayoutManager(linearLayoutManager);
        news_post= news_posts_event_fragment.football_post;
        if (news_post.size()>0){
            news_adapter=new news_adapter(getApplicationContext(),news_post);}
        else {
            Toast.makeText(this, "Please Try Again or check internet", Toast.LENGTH_SHORT).show();
        }
        news_view.setAdapter(news_adapter);
    }
}
