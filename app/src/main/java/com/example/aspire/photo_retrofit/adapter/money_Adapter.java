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
import com.example.aspire.photo_retrofit.Money_Data.Money_Dao;
import com.example.aspire.photo_retrofit.Money_Data.Money_Database;
import com.example.aspire.photo_retrofit.Money_Data.Money_Model;
import com.example.aspire.photo_retrofit.Money_dialog.Money_UpdateDialog;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.ViewHolder;

import java.util.List;

public class money_Adapter extends RecyclerView.Adapter<ViewHolder>{
    public static List<Money_Model> money_list;
    private Context context;
    public static int id;
    public money_Adapter(Context context, List<Money_Model> money_list) {
        this.money_list = money_list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_money_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Money_Model money_model = money_list.get(position);
        holder.money_id.setText(""+(++position));
        holder.money_date.setText(money_model.getDate());
        holder.money_event.setText(money_model.getContent());
        holder.money_income.setText(money_model.getIncome());
        holder.money_outcome.setText(money_model.getOutcome());
        holder.money_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=money_model.getId();
                Money_Model d=new Money_Model(i);
                Money_Dao money_dao = (Money_Dao) Money_Database.getInstance(context).data();
                money_dao.deleteMoney(d);
            }
        });
        holder.money_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=money_model.getId();
                Money_UpdateDialog updateDialog=new Money_UpdateDialog(context);
                updateDialog.addNewMessage(R.layout.money_dialog_layout);
            }
        });

    }

    @Override
    public int getItemCount() {
        return money_list.size();
    }


}
