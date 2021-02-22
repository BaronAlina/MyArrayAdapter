package com.example.myarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентярбь", "Октябрь", "Ноябрь", "Декабрь"};
        double[] temps={10, 12.5, -12, -30, 0, 15, 13.4, 22, -40, -5, 13.5, 12.4};
        int[] days={31, 28, 31, 30, 31, 31, 31, 31, 30, 31, 30, 31};
        MyMonth[] myMonths = new MyMonth[12];
        for (int i=0; i<myMonths.length; i++){
            MyMonth month =new MyMonth();
            month.name=months[i];
            month.days = days[i];
            month.temp = temps[i];
            myMonths[i]=month;
        }
        MyAdapter adapter=new MyAdapter(this, myMonths);
        ListView listView= findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}