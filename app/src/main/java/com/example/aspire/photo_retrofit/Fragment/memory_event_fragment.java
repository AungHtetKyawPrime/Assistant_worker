package com.example.aspire.photo_retrofit.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Memory_Dialog.Memory_MessageDialog;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.adapter.memory_Adapter;
import com.example.aspire.photo_retrofit.memory_Data.Memory_Dao;
import com.example.aspire.photo_retrofit.memory_Data.Memory_DataBae;
import com.example.aspire.photo_retrofit.memory_Data.Memory_Model;

import java.util.List;

import rjsv.floatingmenu.floatingmenubutton.FloatingMenuButton;


public class memory_event_fragment extends Fragment {
    RecyclerView memory_event_list;
    private memory_Adapter adapter;
    FloatingMenuButton add_event;
    public memory_event_fragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.memory_event,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        memory_event_list=(RecyclerView)view.findViewById(R.id.memory_event_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        memory_event_list.setLayoutManager(linearLayoutManager);
        memory_event_list.setHasFixedSize(true);
        add_event=(FloatingMenuButton) view.findViewById(R.id.add_memory_event);
        add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Memory_MessageDialog dialog = new Memory_MessageDialog(getContext());

                dialog.addNewMessage(R.layout.dialog_layout);
                Log.d("Memory dialog ","OK");
                Toast.makeText(getContext(), "Ok add", Toast.LENGTH_SHORT).show();
            }
        });
        Memory_Dao messageDao = (Memory_Dao) Memory_DataBae.getInstance(getContext()).data();
        messageDao.getAllMemory().observe(getActivity(), (List<Memory_Model> data) -> {
            adapter=new memory_Adapter(getContext(),data);//Send data to the future Adapter
            memory_event_list.setAdapter(adapter);//Show these data on the recycler view
        });

    }
}
