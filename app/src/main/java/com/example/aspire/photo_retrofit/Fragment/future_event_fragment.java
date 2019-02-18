package com.example.aspire.photo_retrofit.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.aspire.photo_retrofit.Data.Model;
import com.example.aspire.photo_retrofit.Data.MyDao;
import com.example.aspire.photo_retrofit.Data.MyDataBae;
import com.example.aspire.photo_retrofit.Dialog.MessageDialog;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.adapter.future_Adapter;

import java.util.ArrayList;
import java.util.List;

import rjsv.floatingmenu.floatingmenubutton.FloatingMenuButton;


public class future_event_fragment extends Fragment {
    RecyclerView future_event_list;
    public static List<Model> data_noti;
    private future_Adapter adapter;
    FloatingMenuButton add_event;
    //public static int layout=R.layout.item_future_event;
    public future_event_fragment(){}



    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.future_event,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        future_event_list=(RecyclerView)view.findViewById(R.id.future_event_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        future_event_list.setLayoutManager(linearLayoutManager);
        future_event_list.setHasFixedSize(true);
        add_event=(FloatingMenuButton) view.findViewById(R.id.add_future_event);
        add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ok add", Toast.LENGTH_SHORT).show();
                MessageDialog dialog = new MessageDialog(getContext());
                dialog.addNewMessage(R.layout.dialog_layout);
            }
        });
        MyDao messageDao = (MyDao) MyDataBae.getInstance(getContext()).data();
        messageDao.getAllEvent().observe(getActivity(), (List<Model> data) -> {
            data_noti=data;
            List<Model> data_convert=new ArrayList<>();
            for (int i=data.size()-1;i>0;i--){
                data_convert.add(data.get(i));
            }
            adapter=new future_Adapter(getContext(),data_convert);//Send data to the future Adapter
            future_event_list.setAdapter(adapter);//Show these data on the recycler view
        });

    }
}
