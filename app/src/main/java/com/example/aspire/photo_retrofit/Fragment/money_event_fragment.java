package com.example.aspire.photo_retrofit.Fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Money_Data.Money_Dao;
import com.example.aspire.photo_retrofit.Money_Data.Money_Database;
import com.example.aspire.photo_retrofit.Money_Data.Money_Model;
import com.example.aspire.photo_retrofit.Money_dialog.Money_Dialog;
import com.example.aspire.photo_retrofit.PieChart;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.adapter.money_Adapter;
import com.example.aspire.photo_retrofit.bar_chart;

import java.util.List;

import rjsv.floatingmenu.animation.enumerators.AnimationType;
import rjsv.floatingmenu.floatingmenubutton.FloatingMenuButton;
import rjsv.floatingmenu.floatingmenubutton.MovementStyle;
import rjsv.floatingmenu.floatingmenubutton.subbutton.FloatingSubButton;


public class money_event_fragment extends Fragment {
    public static int in;public static int out;
    FloatingMenuButton bar,pie,money_add;
    RecyclerView money_event_list;
    private money_Adapter adapter;
    TextView result,income_money,outcome_money;
    public money_event_fragment(){}
    public static List<Money_Model> bar_list;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.money_event,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        result=(TextView)view.findViewById(R.id.total_result);
        income_money=(TextView)view.findViewById(R.id.mm_in);
        outcome_money=(TextView)view.findViewById(R.id.mm_out);
        bar = (FloatingMenuButton)view.findViewById(R.id.bar);
        pie = (FloatingMenuButton)view.findViewById(R.id.pie);
        money_add=(FloatingMenuButton)view.findViewById(R.id.add_money_event);
        bar.setStartAngle(0)
                .setEndAngle(360)
                .setRadius(100)
                .setAnimationType(AnimationType.EXPAND);

        pie.setStartAngle(0)
                .setEndAngle(360)
                .setRadius(100)
                .setAnimationType(AnimationType.EXPAND);
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),bar_chart.class));
                Toast.makeText(getContext(), "bar", Toast.LENGTH_SHORT).show();
            }
        });
        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),PieChart.class));
                Toast.makeText(getContext(), "pie", Toast.LENGTH_SHORT).show();
            }
        });
        money_event_list=(RecyclerView)view.findViewById(R.id.money_event_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        money_event_list.setLayoutManager(linearLayoutManager);
        //money_event_list.setHasFixedSize(true);
        money_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ok add ", Toast.LENGTH_SHORT).show();
                Money_Dialog dialog = new Money_Dialog(getContext());
                dialog.addNewMessage(R.layout.money_dialog_layout);
            }
        });
        Money_Dao messageDao = (Money_Dao) Money_Database.getInstance(getContext()).data();
        messageDao.getAllMoney().observe(getActivity(), (List<Money_Model> data) -> {
            Log.d("Money ",data.size()+" Aung ");
            adapter=new money_Adapter(getContext(),data);
            //Send data to the future Adapter
            int a=0,b=0,c;
            for (Money_Model m:data){
                a+=Integer.parseInt(m.getIncome());
                b+=Integer.parseInt(m.getOutcome());

            }
            bar_list=data;
            in=a;out=b;
            income_money.setText("Income "+in);
            outcome_money.setText("Outcome "+out);
            c=in-out;
            result.setText("Total "+c);

            money_event_list.setAdapter(adapter);//Show these data on the recycler view
        });

    }

}
