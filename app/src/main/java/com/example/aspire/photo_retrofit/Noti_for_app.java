package com.example.aspire.photo_retrofit;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class Noti_for_app extends FirebaseMessagingService {
    static String title_message;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size()>0){
            Log.d("Msg Service","Data "+remoteMessage.getData());
            title_message=remoteMessage.getNotification().getTitle();

        }
        if (remoteMessage.getNotification()!=null){
            Log.d("Msg Service",remoteMessage.getNotification().getBody());
            Intent intent=new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
            Uri defaultSoundUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.future_event_noti)  //a resource for your custom small icon
                    .setContentTitle(remoteMessage.getNotification().getTitle()) //the "title" value you sent in your notification
                    .setContentText(remoteMessage.getNotification().getBody()) //ditto
                    .setAutoCancel(true)  //dismisses the notification on click
                    .setContentIntent(pendingIntent);
            NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0,notificationBuilder.build());
        }

    }

    private void send(String body) {

    }

}
