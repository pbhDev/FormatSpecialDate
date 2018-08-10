package com.example.android.formatspecialdate;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {


    private  String dateFromArticle;
    TextView tv_date;
    String mTime = "000";
    SimpleDateFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateFromArticle = "Fri 16 Nov 0012 11.35 EST";

        TextView tv_date = findViewById(R.id.tv_display_date);
        tv_date.setText(dateFromArticle);

    }

    public void formatDate(View view) {

         formatter = new SimpleDateFormat("EEE dd MMM '00'yy HH.mm z", Locale.getDefault());
        //formatter.setTimeZone(TimeZone.getTimeZone("GMT+4")); not needed, the z will tell the TimeZone

        Date myDate;
        long time = 0; //in milli

        try{
            myDate = formatter.parse(dateFromArticle);

            // get the time the article was posted (in long)
            time = myDate.getTime();

        }catch (ParseException e){
            e.printStackTrace();
        }

        //change the formatter
        formatter =  new SimpleDateFormat("MMM dd, yyyy HH:mm z", Locale.getDefault());
        //or without formatter =  new SimpleDateFormat("MMM dd, yy HH:mm ", Locale.getDefault());

        mTime = formatter.format(time);
        tv_date = findViewById(R.id.tv_display_date);
        tv_date.setText(mTime.toString());


    }
}
