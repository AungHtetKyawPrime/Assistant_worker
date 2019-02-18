package com.example.aspire.photo_retrofit.Noti;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.aspire.photo_retrofit.Data.Model;
import com.example.aspire.photo_retrofit.Fragment.future_event_fragment;
import com.example.aspire.photo_retrofit.MainActivity;
import com.example.aspire.photo_retrofit.R;

import java.security.acl.LastOwnerException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.work.Data;
import androidx.work.Worker;


public class Noti_event extends Worker {
    public static final String EXTRA_OUTPUT_MESSAGE = "output_message";
    List<Model> data_for_noti;
    @NonNull
    @Override
    public Result doWork() {
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        int nowYear = c.get(Calendar.YEAR);
        int nowMonth = c.get(Calendar.MONTH);
        int nowDay = c.get(Calendar.DAY_OF_MONTH);
        String formattedDate=nowDay+"-"+(nowMonth+1)+"-"+nowYear;
        String title;
        String text;
        data_for_noti= future_event_fragment.data_noti;
        for (int loop_data=0;loop_data<data_for_noti.size();loop_data++){
            Model date_model=data_for_noti.get(loop_data);

            if (date_model.getDate().equals(formattedDate)){
                title="လာမည့္ အစီအစဥ္ \uD83D\uDECE ";
                text=date_model.getContent();
                sendNotification(title, text);
                Log.d("Aung Ok ",formattedDate);
            }
            Log.d("Alarm Date ",date_model.getDate()+" "+date_model.getContent()+"/ "+formattedDate);
        }
        //sendNotification("Simple Work Manager", "I have been send by WorkManager!");

        Data output = new Data.Builder()
                .putString(EXTRA_OUTPUT_MESSAGE, "I have come from MyWorker!")
                .build();

        setOutputData(output);

        return Result.SUCCESS;
    }
    public void sendNotification(String title, String message) {

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),
                0,intent,PendingIntent.FLAG_ONE_SHOT);
        //If on Oreo then notification required a notification channel.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            //This may have some noti problem
        }
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formatted_time= dateFormat.format(date);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setContentTitle(title+" * ")
                .setContentText(message)
                .setSmallIcon(R.drawable.future_event_noti)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify(1, notification.build());
    }
}
