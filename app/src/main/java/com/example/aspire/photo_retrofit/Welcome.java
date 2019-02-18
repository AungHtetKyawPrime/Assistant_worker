package com.example.aspire.photo_retrofit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.aspire.photo_retrofit.Noti.Noti_event;

import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;


public class Welcome extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    PeriodicWorkRequest periodicWorkRequest;
    OneTimeWorkRequest simpleRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        /*
        * SplashScreenBuilder.getInstance(this)
                .setVideo(R.raw.splash_animation)
                .setImage(R.drawable.app_icon)
                .show();

        Button restart_app = findViewById(R.id.restart_app);
        restart_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Restart app
                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SplashScreenBuilder.SPLASH_SCREEN_FINISHED) {
            if(resultCode == RESULT_OK) {
                startActivity(new Intent(this,MainActivity.class));
                Toast.makeText(this, "SplashScreen finished", Toast.LENGTH_SHORT).show();
            } else if(resultCode == RESULT_CANCELED) {
               // Toast.makeText(this, "SplashScreen finished, but canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Welcome.this,MainActivity.class);
                Welcome.this.startActivity(mainIntent);
                Welcome.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Data data = new Data.Builder()
                .putString(MainActivity.EXTRA_TITLE, "Aung Htet!")
                .putString(MainActivity.EXTRA_TEXT, "I am Optimus Prime")
                .build();
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .build();
        simpleRequest= new OneTimeWorkRequest.Builder(Noti_event.class)
                .setInputData(data)
                .setConstraints(constraints)
                .addTag("simple_work")
                .build();
        periodicWorkRequest= new PeriodicWorkRequest.Builder(Noti_event.class, 10, TimeUnit.SECONDS)
                .addTag("periodic_work")
                .build();
        WorkManager.getInstance().enqueue(periodicWorkRequest);
        Log.d("WorkManager ","Ok ");

    }
}
