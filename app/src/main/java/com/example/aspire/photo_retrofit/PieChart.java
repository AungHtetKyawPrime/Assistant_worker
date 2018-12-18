package com.example.aspire.photo_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aspire.photo_retrofit.Fragment.money_event_fragment;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        com.github.mikephil.charting.charts.PieChart pieChart = findViewById(R.id.piechart);
        ArrayList NoOfEmp = new ArrayList();
        float a=money_event_fragment.in;
        float b=money_event_fragment.out;
        NoOfEmp.add(new Entry(a, 0));
        NoOfEmp.add(new Entry(b, 1));
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");
        Log.d("Pie Aung", money_event_fragment.in+"");
        ArrayList year = new ArrayList();


        year.add("Income");
        year.add("Outcome");
        PieData data = new PieData(year, dataSet);
        pieChart.setData(data);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.animateXY(5000, 5000);
    }
}
