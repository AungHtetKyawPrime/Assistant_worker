package com.example.aspire.photo_retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aspire.photo_retrofit.Memory_Dialog.Memory_UpdateDialog;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.ViewHolder;
import com.example.aspire.photo_retrofit.memory_Data.Memory_Dao;
import com.example.aspire.photo_retrofit.memory_Data.Memory_DataBae;
import com.example.aspire.photo_retrofit.memory_Data.Memory_Model;

import java.util.List;


public class memory_Adapter extends RecyclerView.Adapter<ViewHolder>{
    public static List<Memory_Model> event_list;
    private Context context;
    public static int id;
    public memory_Adapter(Context context, List<Memory_Model> event_list) {
        this.event_list = event_list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Memory_Model event = event_list.get(position);


        holder.memory_no_id.setText("စဥ္"+(++position));
        holder.memory_content.setText(""+event.getContent());
        Log.i("adapter data => ","ok");
        holder.memory_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add a code that can delete a message
                // item when the delete icon is clicked
                int i=event.getId();
                Memory_Model d=new Memory_Model(i);
                Memory_Dao messageDao = (Memory_Dao) Memory_DataBae.getInstance(context).data();
                messageDao.deleteMemory(d);
                //Toast.makeText(context, "စဥ္" + i+" ကိုဖ်က္ ပီးပါပီ ခင္ ဗ်ာ", Toast.LENGTH_SHORT).show();
            }
        });
        holder.memory_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=event.getId();
                Memory_UpdateDialog updateDialog=new Memory_UpdateDialog(context);
                updateDialog.addNewMessage(R.layout.dialog_layout);
            }
        });
    }

    @Override
    public int getItemCount() {
        return event_list.size();
    }


}
