package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import basicClass.ourException;

public class conditional_booking3 extends AppCompatActivity {
    private Button confirmation;
    private EditText input_name;
    private EditText input_age;
    private String number_sheets;
    private String movie;
    private String time;
    private String movieorder;
    private String continuity;
    private String assign;
    private String assignrow;
    private String row;
    private String region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.conditional_booking3);
            confirmation = (Button) findViewById(R.id.confirmation);
            input_age=(EditText)findViewById(R.id.input_age);
            input_name=(EditText)findViewById(R.id.input_name);

            Bundle bundle = this.getIntent().getExtras();

            number_sheets = bundle.getString( "number_sheets"  );
            movie=bundle.getString("movie");
            time=bundle.getString("time");
            movieorder=bundle.getString("movieorder");
            continuity=bundle.getString("continue");
            assign=bundle.getString("assign");
            assignrow=bundle.getString("assignrow");
            row=bundle.getString("row");
            region=bundle.getString("region");


            confirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if ("".equals( input_name.getText().toString() ) ||
                                "".equals( input_age.getText().toString() )) {
                            throw new ourException( "有問題尚未回答" );
                        }
                    Intent intent = new Intent();
                    intent.setClass(conditional_booking3.this, conditional_booking4.class);
                        intent.putExtra( "number_sheets", number_sheets );
                        intent.putExtra( "movie", movie );
                        intent.putExtra( "time", time );
                        intent.putExtra( "name", input_name.getText().toString() );
                        intent.putExtra( "age", input_age.getText().toString() );
                        intent.putExtra( "movieorder", movieorder );
                        intent.putExtra("continuity",continuity);
                        intent.putExtra("assignrow", assignrow);
                        intent.putExtra("assign", assign);
                        intent.putExtra("row", row);
                        intent.putExtra("region", region);

                    startActivity(intent);
                    } catch (ourException e) {
                        Toast.makeText( conditional_booking3.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                    }
                }
            });
        }catch (Exception e){
            Toast.makeText(conditional_booking3.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
