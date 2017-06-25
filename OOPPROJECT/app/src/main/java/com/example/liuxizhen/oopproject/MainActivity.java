package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
    private boolean doubleBackToExitPressedOnce = false;
    private String cannotgoback = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {

            Base.loadMovie();
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            booking = (ImageButton) findViewById( R.id.booking );
            refund = (ImageButton) findViewById( R.id.refund );
            conditional_booking = (ImageButton) findViewById( R.id.conditional_booking );
            search = (ImageButton) findViewById( R.id.search );

            if (this.getIntent().getExtras() != null) {
                Bundle bundle = this.getIntent().getExtras();
                doubleBackToExitPressedOnce = Boolean.parseBoolean(bundle.getString("directgoback" ));
            }


            booking.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cannotgoback = "no";
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, booking1.class );
                    startActivity( intent );
                }
            } );
            refund.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cannotgoback = "no";
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, refund1.class );
                    startActivity( intent );
                }
            } );
            conditional_booking.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cannotgoback = "no";
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, conditional_booking1.class );
                    startActivity( intent );
                }
            } );
            search.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cannotgoback = "no";
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, search.class );
                    startActivity( intent );
                }
            } );
        }catch(Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "再按一下退出程式", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed( new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}



