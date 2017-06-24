package com.example.liuxizhen.oopproject;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import basicClass.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class search_time1 extends AppCompatActivity {
    private Button start_time;
    private Button end_time;

    private TimePickerDialog timePickerDialog2;
    private TimePickerDialog timePickerDialog;
    private Button confirmation;
    public ourtime start_ourtime;
    public ourtime end_ourtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_time1);
        start_time = (Button) findViewById(R.id.timestart);
        end_time = (Button) findViewById(R.id.timeend);
        confirmation = (Button) findViewById(R.id.confirmation);
        GregorianCalendar calendar = new GregorianCalendar();

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search_time1.this, search_time2.class);
                startActivity(intent);

            }
        });


        // 實作TimePickerDialog的onTimeSet方法，設定時間後將所設定的時間show在textTime上
        timePickerDialog = new TimePickerDialog(this, new OnTimeSetListener() {
            //將時間轉為12小時製顯示出來
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                start_time.setText((hourOfDay > 12 ? hourOfDay - 12 : hourOfDay)
                        + ":" + minute + " " + (hourOfDay > 12 ? "PM" : "AM"));
                start_ourtime = new ourtime(hourOfDay, minute);

            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(calendar.MINUTE),
                false);
        // 實作TimePickerDialog的onTimeSet方法，設定時間後將所設定的時間show在textTime上
        timePickerDialog2 = new TimePickerDialog(this, new OnTimeSetListener() {
            //將時間轉為12小時製顯示出來
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                end_time.setText((hourOfDay > 12 ? hourOfDay - 12 : hourOfDay)
                        + ":" + minute + " " + (hourOfDay > 12 ? "PM" : "AM"));
                end_ourtime = new ourtime(hourOfDay, minute);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(calendar.MINUTE),
                false);
    }


    // setTime Button onClick 顯示時間設定視窗
    public void setTime(View v) {
        timePickerDialog.show();
    }

    // setTime Button onClick 顯示時間設定視窗
    public void setTime2(View v) {
        timePickerDialog2.show();
    }

    public void reset(View v) {
        start_time.setText("-- : --");
    }

    public void reset2(View v) {
        end_time.setText("-- : --");

    }
}
