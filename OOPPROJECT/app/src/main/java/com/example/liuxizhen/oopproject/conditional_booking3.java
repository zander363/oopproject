package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class conditional_booking3 extends AppCompatActivity {
    private Button confirmation;
    private EditText input_name;
    private EditText input_age;
    private String number_sheets;
    private String movie;
    private String time;
    private String movieorder;
    private boolean samerow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditional_booking3);
        confirmation = (Button) findViewById(R.id.confirmation);
            input_age=(EditText)findViewById(R.id.input_age);

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(conditional_booking3.this, conditional_booking4.class);
                startActivity(intent);
            }
        });
        }catch (Exception e){
            Toast.makeText(conditional_booking3.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
