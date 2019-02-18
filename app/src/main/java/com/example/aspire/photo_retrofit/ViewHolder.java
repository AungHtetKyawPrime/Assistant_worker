package com.example.aspire.photo_retrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView future_no_id,future_date,future_event,like,heart,seen,animal,news_title,news_author,news_content
            ,memory_no_id,memory_content,money_id,money_date,money_event,money_income,money_outcome;
    public ImageView update,delete,post,news_img,memory_update,memory_delete,money_update,money_delete;
    public RelativeLayout memory_color;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        //for future events
        future_no_id=(TextView)itemView.findViewById(R.id.future_no_id);
        future_date=(TextView)itemView.findViewById(R.id.future_date);
        future_event=(TextView)itemView.findViewById(R.id.future_event);
        update=(ImageView)itemView.findViewById(R.id.content_update);
        delete=(ImageView)itemView.findViewById(R.id.content_delete);
        /// for post view
        post=(ImageView)itemView.findViewById(R.id.posts);
        like=(TextView)itemView.findViewById(R.id.like_of_post);
        heart=(TextView)itemView.findViewById(R.id.heart_of_post);
        seen=(TextView)itemView.findViewById(R.id.seen_of_post);
        //for football view
        news_img=(ImageView)itemView.findViewById(R.id.news_football_post);
        news_title=(TextView) itemView.findViewById(R.id.news_title);
        news_author=(TextView) itemView.findViewById(R.id.news_author);
        news_content=(TextView) itemView.findViewById(R.id.news_content);
        //for memory view
        memory_content=(TextView)itemView.findViewById(R.id.memory_event);
        memory_no_id=(TextView)itemView.findViewById(R.id.memory_no_id);
        memory_delete=(ImageView)itemView.findViewById(R.id.memory_content_delete);
        memory_update=(ImageView)itemView.findViewById(R.id.memory_content_update);
        memory_color=(RelativeLayout) itemView.findViewById(R.id.memory_color);
        //for money view
        money_id=(TextView)itemView.findViewById(R.id.money_no_id);
        money_date=(TextView)itemView.findViewById(R.id.money_date);
        money_event=(TextView)itemView.findViewById(R.id.money_event);
        money_income=(TextView)itemView.findViewById(R.id.money_income);
        money_outcome=(TextView)itemView.findViewById(R.id.money_outcome);
        money_update=(ImageView)itemView.findViewById(R.id.money_update);
        money_delete=(ImageView)itemView.findViewById(R.id.money_delete);

    }
}
