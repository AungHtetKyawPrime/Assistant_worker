package com.example.aspire.photo_retrofit;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.aspire.photo_retrofit.Fragment.future_event_fragment;
import com.example.aspire.photo_retrofit.Fragment.memory_event_fragment;
import com.example.aspire.photo_retrofit.Fragment.money_event_fragment;
import com.example.aspire.photo_retrofit.Fragment.news_posts_event_fragment;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_api;
import com.example.aspire.photo_retrofit.Retrofit.Retrofit_model;
import com.example.aspire.photo_retrofit.Retrofit.retrofit_data;
import java.util.List;

import hari.floatingtoast.FloatingToast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    ProgressBar myProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*Create handle for the RetrofitInstance interface*/
        //MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new future_event_fragment());

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.event:
                    String text1 = "Future Event ";
                    FloatingToast.makeToast(MainActivity.this, text1, FloatingToast.LENGTH_MEDIUM).show();
                    fragment = new future_event_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.memory:
                    String text = "Memory Event ";
                    int duration = FloatingToast.LENGTH_MEDIUM;
                    FloatingToast.makeToast(MainActivity.this, text, FloatingToast.LENGTH_MEDIUM).show();
                    fragment = new memory_event_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.money:

                    fragment = new money_event_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.news:

                    fragment = new news_posts_event_fragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };



    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        String text = "Future Event ";
        int duration = FloatingToast.LENGTH_MEDIUM;
        FloatingToast.makeToast(MainActivity.this, text, FloatingToast.LENGTH_MEDIUM).show();
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
