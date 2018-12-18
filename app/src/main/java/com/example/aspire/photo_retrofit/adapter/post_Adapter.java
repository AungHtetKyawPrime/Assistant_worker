package com.example.aspire.photo_retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aspire.photo_retrofit.Data.Model;
import com.example.aspire.photo_retrofit.Data.MyDao;
import com.example.aspire.photo_retrofit.Data.MyDataBae;
import com.example.aspire.photo_retrofit.Dialog.UpdateDialog;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_model;
import com.example.aspire.photo_retrofit.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class post_Adapter extends RecyclerView.Adapter<ViewHolder>{
    public static List<Retrofit_model.photo_data> photos;
    private Context context;
    public static int id;
    public post_Adapter(Context context, List<Retrofit_model.photo_data> photos) {
        this.photos=photos;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Retrofit_model.photo_data data_pose = photos.get(position);
        Picasso.get().load(data_pose.getImg()).placeholder(R.drawable.camera).into(holder.post);
        holder.like.setText(data_pose.likes+"");
        holder.heart.setText(data_pose.favorites+"");
        holder.seen.setText(data_pose.views+"");
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }


}
