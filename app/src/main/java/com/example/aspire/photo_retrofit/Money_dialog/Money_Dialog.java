package com.example.aspire.photo_retrofit.Money_dialog;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Data.Model;
import com.example.aspire.photo_retrofit.Data.MyDao;
import com.example.aspire.photo_retrofit.Data.MyDataBae;
import com.example.aspire.photo_retrofit.Money_Data.Money_Dao;
import com.example.aspire.photo_retrofit.Money_Data.Money_Database;
import com.example.aspire.photo_retrofit.Money_Data.Money_Model;
import com.example.aspire.photo_retrofit.R;

import java.util.Calendar;


public class Money_Dialog {
    String date;TextView money_date;
    private int mYear, mMonth, mDay;
    private Context context;

    public Money_Dialog(Context context) {
        this.context = context;
    }

    public void addNewMessage(int dialog_layout){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(dialog_layout, null);

        money_date = (TextView) subView.findViewById(R.id.date);
        final EditText event = (EditText)subView.findViewById(R.id.money_event_about);
        final EditText money_income = (EditText)subView.findViewById(R.id.income);
        final EditText money_outcome = (EditText)subView.findViewById(R.id.outcome);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ဘာအေၾကာင္း အရာပါလဲ ခင္ဗ်ာ? \uD83D\uDE0A");
        builder.setView(subView);
        builder.create();
        money_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init_date();
            }
        });
        builder.setPositiveButton("အိုေက \uD83D\uDE09", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                final String title = event.getText().toString();
                 String income_a = money_income.getText().toString();
                 String outcome_b = money_outcome.getText().toString();
                if((TextUtils.isEmpty(title) || TextUtils.isEmpty(date)) &&
                        (TextUtils.isEmpty(income_a) && TextUtils.isEmpty(outcome_b))){
                    //if (outcome_b.length()<0)outcome_b="0";if (income_a.length()<0)income_a="0";
                    Toast.makeText(context, "အစီအစဥ္ ေလး ေတာ့ ထည့္ ပါ ဦ း ဗ် \uD83D\uDE01 ", Toast.LENGTH_LONG).show();
                }
                else{
                    if (income_a.length()<1)income_a="0";
                    if (outcome_b.length()<1)outcome_b="0";
                    Money_Model content = new Money_Model(title,date,income_a,outcome_b);

                    //add new message to database
                    Money_Dao messageDao = (Money_Dao) Money_Database.getInstance(context).data();
                    messageDao.insertMoney(content);
                }
            }
        });
        builder.setNegativeButton("မလုပ္ေတာ့ပါ \uD83D\uDE05", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
    private void init_date() {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        date=dayOfMonth+"-"+(monthOfYear+1)+"-"+year;

                        money_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
