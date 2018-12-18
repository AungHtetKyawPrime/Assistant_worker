package com.example.aspire.photo_retrofit.Money_dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Data.MyDao;
import com.example.aspire.photo_retrofit.Data.MyDataBae;
import com.example.aspire.photo_retrofit.Money_Data.Money_Dao;
import com.example.aspire.photo_retrofit.Money_Data.Money_Database;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.adapter.future_Adapter;
import com.example.aspire.photo_retrofit.adapter.money_Adapter;


public class Money_UpdateDialog {
    private Context context;int n;int id;

    public Money_UpdateDialog(Context context) {
        this.context = context;
    }


    public void addNewMessage(int dialog_layout){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(dialog_layout, null);


        final EditText money_date = (EditText)subView.findViewById(R.id.date);
        final EditText event = (EditText)subView.findViewById(R.id.money_event_about);
        final EditText money_income = (EditText)subView.findViewById(R.id.income);
        final EditText money_outcome = (EditText)subView.findViewById(R.id.outcome);


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ဘယ္ အခ်က္ မ်ား ျပင္ ဆင္ ခ်င္ ပါ လဲ ဗ်ာ \uD83D\uDD8E ?");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("အိုေက \uD83D\uDE09", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String date = money_date.getText().toString();
                final String title = event.getText().toString();
                String income_a = money_income.getText().toString();
                String outcome_b = money_outcome.getText().toString();
                if((TextUtils.isEmpty(title) || TextUtils.isEmpty(date)) &&
                        (TextUtils.isEmpty(income_a) && TextUtils.isEmpty(outcome_b))){
                    Toast.makeText(context, "အစီအစဥ္ ေလး ေတာ့ ထည့္ ပါ ဦ း ဗ် \uD83D\uDE01 ", Toast.LENGTH_LONG).show();
                }
                else{

                    int id= money_Adapter.id;


                    //add new message to database
                    Money_Dao money_dao = (Money_Dao) Money_Database.getInstance(context).data();
                    if (income_a.length()<1)income_a="0";
                    if (outcome_b.length()<1)outcome_b="0";
                    money_dao.updateMoney(title,date,income_a,outcome_b,id);
                    Toast.makeText(context, "စဥ ္" + id+" ကို ျပင္ဆင္ ပီးပါပီ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("မလုပ္ေတာ့ပါ \uD83D\uDE05", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(context, "Task cancelled", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

}
