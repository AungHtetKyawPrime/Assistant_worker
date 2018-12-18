package com.example.aspire.photo_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aspire.photo_retrofit.Fragment.money_event_fragment;
import com.example.aspire.photo_retrofit.Money_Data.Money_Model;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class bar_chart extends AppCompatActivity {
    BarChart chart;List<Money_Model> data_of_bar;float income_bar,outcome_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        chart= findViewById(R.id.barchart);
        data_of_bar= money_event_fragment.bar_list;
        final ArrayList NoOfEmp = new ArrayList();
        for (int i=0;i<data_of_bar.size();i++){
            Money_Model m=data_of_bar.get(i);
            income_bar=Float.parseFloat(m.getIncome());
            NoOfEmp.add(new BarEntry(income_bar, i));

        }

        ArrayList year = new ArrayList();

        year.add("Jan");
        year.add("Feb");
        year.add("March");
        year.add("April");
        year.add("May");
        year.add("June");
        year.add("July");
        year.add("Aug");
        year.add("Sep");
        year.add("Oct");
        year.add("Nov");
        year.add("Dec");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "No Of Employee");
        chart.animateY(5000);
        BarData data = new BarData( year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);


        chart.setData(data);
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                float a=e.getXIndex();
                Toast.makeText(bar_chart.this, ""+(int)a, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
