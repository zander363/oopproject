package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

import basicMethod.Base;


public class MainActivity extends AppCompatActivity {
    private ImageButton booking;
    private ImageButton refund;
    private ImageButton conditional_booking;
    private ImageButton search;
    //判斷離開的flag，設定成全域變數
    private boolean is_exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Base.loadMovie();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booking = (ImageButton) findViewById(R.id.booking);
        refund = (ImageButton) findViewById(R.id.refund);
        conditional_booking = (ImageButton) findViewById(R.id.conditional_booking);
        search = (ImageButton) findViewById(R.id.search);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, booking1.class);
                startActivity(intent);
            }
        });
        refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, refund1.class);
                startActivity(intent);
            }
        });
        conditional_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, conditional_booking1.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, search.class);
                startActivity(intent);
            }
        });



    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean returnValue = false;
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 && is_exit == false) {
            Toast.makeText(getBaseContext(),"再按一次結束程式", Toast.LENGTH_SHORT).show();
            is_exit = true;
            // 一開始 先設定 返回的 flag = true ,若使用者兩秒內沒有動作，則將該 flag 恢復為 false
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                        is_exit = false;
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
            returnValue = true;
        } else {
            returnValue = super.onKeyDown(keyCode, event);
        }
        return returnValue;
    }
}

