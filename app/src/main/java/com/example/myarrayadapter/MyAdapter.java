package com.example.myarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<MyMonth> {

    public MyAdapter(@NonNull Context context, MyMonth[] myMonths) {
        super(context, R.layout.item_adapter1, myMonths);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final  MyMonth myMonth = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_adapter1, null);
        }

        ((TextView)convertView.findViewById(R.id.month_name)).setText(myMonth.name);
        ((TextView)convertView.findViewById(R.id.month_day)).setText(String.valueOf(myMonth.days));
        ((TextView)convertView.findViewById(R.id.month_temp)).setText(String.valueOf(myMonth.temp));

        if (myMonth.temp > 0){
            ((ImageView)convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.sun);
        }else {
            ((ImageView)convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.cloud);
        }

        final CheckBox checkBox= convertView.findViewById(R.id.month_like);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMonth.like = checkBox.isChecked();
            }
        });
        return convertView;
    }
}
