package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class booking3 extends AppCompatActivity {
    private Button confirmation;
    private TextView booking_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking3);
        confirmation = (Button) findViewById(R.id.confirmation);
        booking_result = (TextView) findViewById(R.id.booking_result);

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(booking3.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Bundle bundle = this.getIntent().getExtras();

        String number_sheets = bundle.getString("number_sheets");
        String movie = bundle.getString("movie");
        String time = bundle.getString("time");
        String age = bundle.getString("age");
        String name = bundle.getString("name");

        //要接從第一頁接的數字
        booking_result.setText(
                "電影名稱："+movie+"\n"+
                "場次："+time+"\n"+
                "張數："+number_sheets+"\n"+
                "年齡："+age+"\n"+
                "名字："+name);


    }

    public void Touch(View v) {
        finish();//返回上一個Activity
    }
}
