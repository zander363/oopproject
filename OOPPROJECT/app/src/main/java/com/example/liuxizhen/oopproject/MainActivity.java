package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.io.IOException;

import basicClass.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import basicMethod.Base;
import android.database.sqlite.SQLiteDatabase;



public class MainActivity extends AppCompatActivity {
    private ImageButton booking;
    private ImageButton refund;
    private ImageButton conditional_booking;
    private ImageButton search;
    //判斷離開的flag，設定成全域變數
    private boolean doubleBackToExitPressedOnce = false;
    private UserDBHelper helper;
    OOPUser oopuser;



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
            oopuser = new OOPUser(this);
            helper = new UserDBHelper(this, "oop.movie", null, 1);
            if (oopuser.getCount() == 0) {
                oopuser.connect();
            }

            if (this.getIntent().getExtras() != null) {
                Bundle bundle = this.getIntent().getExtras();
                doubleBackToExitPressedOnce = Boolean.parseBoolean(bundle.getString("directgoback" ));
            }




            booking.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doubleBackToExitPressedOnce = false;
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, booking1.class );
                    startActivity( intent );
                }
            } );
            refund.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doubleBackToExitPressedOnce = false;
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, refund1.class );
                    startActivity( intent );
                }
            } );
            conditional_booking.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doubleBackToExitPressedOnce = false;
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, conditional_booking1.class );
                    startActivity( intent );
                }
            } );
            search.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doubleBackToExitPressedOnce = false;
                    Intent intent = new Intent();
                    intent.setClass( MainActivity.this, search.class );
                    startActivity( intent );
                }
            } );
        }catch(Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
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
