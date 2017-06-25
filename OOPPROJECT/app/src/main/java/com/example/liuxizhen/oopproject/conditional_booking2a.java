package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import basicClass.ourException;

public class conditional_booking2a extends AppCompatActivity {
    private Button confirmation;
    private String number_sheets;
    private String movie;
    private String time;
    private String movieorder;
    private String continuity;
    private String assign;
    private String assignrow;
    private String row;
    private String region;
    private Spinner row_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditional_booking2a);
        confirmation = (Button) findViewById(R.id.confirmation);

            Bundle bundle = this.getIntent().getExtras();

            number_sheets = bundle.getString( "number_sheets"  );
            movie=bundle.getString("movie");
            time=bundle.getString("time");
            movieorder=bundle.getString("movieorder");
            continuity=bundle.getString("continue");
            assign=bundle.getString("assign");
            assignrow=bundle.getString("assignrow");



        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (!"請選擇排".equals(row_spinner.getSelectedItem().toString())) {
                        throw new ourException( "有問題尚未回答" );
                    }
                Intent intent = new Intent();
                intent.setClass(conditional_booking2a.this, conditional_booking3.class);
                intent.putExtra( "number_sheets", number_sheets );
                intent.putExtra( "movie", movie );
                intent.putExtra( "time", time );
                intent.putExtra( "movieorder", movieorder );
                intent.putExtra("continuity",continuity);
                intent.putExtra("assignrow", assignrow);
                intent.putExtra("assign", assign);
                    intent.putExtra("row", row);
                startActivity(intent);
                }catch(ourException e){
                    Toast.makeText( conditional_booking2a.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }catch (Exception e){
            Toast.makeText(conditional_booking2a.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
