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

import com.example.aspire.photo_retrofit.Data.Model;
import com.example.aspire.photo_retrofit.Data.MyDao;
import com.example.aspire.photo_retrofit.Data.MyDataBae;
import com.example.aspire.photo_retrofit.R;

import java.util.Calendar;


public class MessageDialog {
    String date;private int day_of_month,month_of_year,year_no;public static int different_of_days,
            different_of_month,different_of_year,now_day,now_month,now_year;
    int total_days=0;
    int[] month={31,28,31,30,31,30,31,31,30,31,30,31};
    TextView nameField;
    private int mYear, mMonth, mDay;
    private Context context;

    public MessageDialog(Context context) {
        this.context = context;
    }

    public void addNewMessage(int dialog_layout){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(dialog_layout, null);

         nameField= (TextView) subView.findViewById(R.id.date);
        final EditText nameField1 = (EditText)subView.findViewById(R.id.title);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ဘာအေၾကာင္း အရာပါလဲ ခင္ဗ်ာ? \uD83D\uDE0A");
        builder.setView(subView);
        builder.create();
        nameField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
                init_date();
                Log.d("Hello ","Aung Htet Text");
            }
        });
        builder.setPositiveButton("အိုေက \uD83D\uDE09", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                final String title = nameField1.getText().toString();
                if(TextUtils.isEmpty(title) || TextUtils.isEmpty(date)){
                    Toast.makeText(context, "အစီအစဥ္ ေလး ေတာ့ ထည့္ ပါ ဦ း ဗ် \uD83D\uDE01 ", Toast.LENGTH_LONG).show();
                }
                else{
                    Calculate_Days();
                    Model content = new Model(title,date);

                    //add new message to database
                    MyDao messageDao = (MyDao) MyDataBae.getInstance(context).data();
                    messageDao.insertEvent(content);
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

    private void Calculate_Days() {

        Calendar calendar=Calendar.getInstance();
        now_day=calendar.get(Calendar.DAY_OF_MONTH);
        now_month=calendar.get(Calendar.MONTH)+1;
        now_year=calendar.get(Calendar.YEAR);
        different_of_year=year_no-now_year;
        different_of_month=(month_of_year+(different_of_year*12))-now_month;

        if (different_of_month ==1 ){
        different_of_days=(day_of_month+(different_of_month*month[month_of_year-1]))-now_day;
            }

        if (different_of_month >1){
            for (int i=month_of_year-1;i>=0;i--){
                total_days+=month[i];
                Log.d("Larger  ",month[i]+" ");

            }Log.d("Total  Days",total_days+" ");
            different_of_days=(day_of_month+(total_days))-now_day;
            Log.d("Differ Days ",different_of_days+" ");
        }



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
                        month_of_year=monthOfYear+1;
                        year_no=year;
                        nameField.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
