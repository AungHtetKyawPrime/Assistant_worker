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
import com.example.aspire.photo_retrofit.ViewHolder;

import java.util.List;

public class future_Adapter extends RecyclerView.Adapter<ViewHolder>{
    public static List<Model> messageList;
    private Context context;
    public static int id;
    public future_Adapter(Context context, List<Model> messageList) {
        this.messageList = messageList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_future_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Model event = messageList.get(position);


        holder.future_no_id.setText(" Event No"+(++position));
        holder.future_date.setText("ေန႔စြဲ   "+event.getDate());
        holder.future_event.setText("အစီအစဥ္\uD83D\uDC4C  "+event.getContent());
        Log.i("adapter data => ","ok");
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add a code that can delete a message
                // item when the delete icon is clicked
                int i=event.getId();
                Model d=new Model(i);
                MyDao messageDao = (MyDao) MyDataBae.getInstance(context).data();
                messageDao.deleteEvent(d);
                //Toast.makeText(context, "စဥ္" + i+" ကိုဖ်က္ ပီးပါပီ ခင္ ဗ်ာ", Toast.LENGTH_SHORT).show();
            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=event.getId();
                UpdateDialog updateDialog=new UpdateDialog(context);
                updateDialog.addNewMessage(R.layout.dialog_layout);
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


}
