package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

import basicMethod.Base;

public class booking3 extends AppCompatActivity {
    private Button confirmation;
    private TextView booking_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.booking3);
            confirmation = (Button) findViewById(R.id.confirmation);
            booking_result = (TextView) findViewById(R.id.booking_result);

            confirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(booking3.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            });
            Bundle bundle = this.getIntent().getExtras();

            String number_sheets = bundle.getString("number_sheets");
            String movie = bundle.getString("movie");
            String time = bundle.getString("time");
            int age = bundle.getInt("age");
            String name = bundle.getString("name");
            int movieorder = bundle.getInt("movieorder");

            if (age < Base.moviesList[movieorder].level){
                booking_result.setText("年齡不合法！");
            }
            else{
                booking_result.setText(
                        "電影名稱：" + movie + "\n" +
                                "場次：" + time + "\n" +
                                "張數：" + number_sheets + "\n" +
                                "年齡：" + age + "\n" +
                                "名字：" + name);
            }


        }catch(Exception e){
            Toast.makeText(booking3.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setClass(booking3.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
