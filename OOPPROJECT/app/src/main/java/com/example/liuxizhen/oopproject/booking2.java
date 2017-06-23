package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class booking2 extends AppCompatActivity {
    private Button confirmation;
    private EditText input_name;
    private EditText input_age;
    private String number_sheets;
    private String movie;
    private String time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking2);
        confirmation = (Button) findViewById(R.id.confirmation);
        input_name = (EditText) findViewById(R.id.input_name);
        input_age = (EditText) findViewById(R.id.input_age);

        Bundle bundle = this.getIntent().getExtras();

        number_sheets = bundle.getString("number_sheets");
        movie = bundle.getString("movie");
        time = bundle.getString("time");

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(booking2.this, booking3.class);
                startActivity(intent);
                intent.putExtra("number_sheets", number_sheets);
                intent.putExtra("movie", movie);
                intent.putExtra("time", time);
                intent.putExtra("name", input_name.getText().toString());
                intent.putExtra("age", input_age.getText().toString());
                //把字串傳到第二個Activity
                startActivity(intent);
            }
        });
    }
}