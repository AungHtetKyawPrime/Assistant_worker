package com.example.aspire.photo_retrofit.Dialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Data.MyDao;
import com.example.aspire.photo_retrofit.Data.MyDataBae;
import com.example.aspire.photo_retrofit.R;
import com.example.aspire.photo_retrofit.adapter.future_Adapter;

import java.util.Calendar;


public class UpdateDialog {
    String date;private int day_of_month;public static int different_of_days;
    TextView date_Field;
    private int mYear, mMonth, mDay;
    private Context context;int n;int id;

    public UpdateDialog(Context context) {
        this.context = context;
    }


    public void addNewMessage(int dialog_layout){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(dialog_layout, null);

        date_Field = (TextView) subView.findViewById(R.id.date);
        final EditText nameField1 = (EditText)subView.findViewById(R.id.title);
        date_Field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
                init_date();
                Log.d("Hello ","Aung Htet Text");
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ဘယ္ အခ်က္ မ်ား ျပင္ ဆင္ ခ်င္ ပါ လဲ ဗ်ာ \uD83D\uDD8E ?");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("အိုေက \uD83D\uDE09", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                final String title = nameField1.getText().toString();
                if(TextUtils.isEmpty(title) || TextUtils.isEmpty(date)){
                    Toast.makeText(context, "အစီအစဥ္ ေလး ေတာ့ ထည့္ ပါ ဦ း ဗ် \uD83D\uDE01 ", Toast.LENGTH_LONG).show();
                }
                else{

                    int id= future_Adapter.id;


                    //add new message to database
                    MyDao messageDao = (MyDao) MyDataBae.getInstance(context).data();
                    messageDao.updateEvent(title,date,id);
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
                        day_of_month=dayOfMonth;
                        date_Field.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}
