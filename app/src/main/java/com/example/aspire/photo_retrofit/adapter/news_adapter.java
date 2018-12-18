package com.example.aspire.photo_retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_model;
import com.example.aspire.photo_retrofit.Retrofit.news_model;
import com.example.aspire.photo_retrofit.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class news_adapter extends RecyclerView.Adapter<ViewHolder>{
    public static List<news_model.news> news;
    private Context context;
    public static int id;
    public news_adapter(Context context, List<news_model.news> news) {
        this.news=news;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_football, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        news_model.news news_model= news.get(position);
        Picasso.get().load(news_model.getImg()).placeholder(R.drawable.camera).into(holder.news_img);
        holder.news_title.setText(news_model.news_title);
        holder.news_content.setText("News -> "+news_model.news_content);
        holder.news_author.setText(news_model.author);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }


}
