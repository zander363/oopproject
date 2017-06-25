package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import basicClass.ourException;
import basicMethod.Base;

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
            row_spinner = (Spinner)findViewById(R.id.row_spinner);

            Bundle bundle = this.getIntent().getExtras();

            number_sheets = bundle.getString( "number_sheets"  );
            movie=bundle.getString("movie");
            time=bundle.getString("time");
            movieorder=bundle.getString("movieorder");
            continuity=bundle.getString("continue");
            assign=bundle.getString("assign");
            assignrow=bundle.getString("assignrow");
            region = bundle.getString("region");




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
                    intent.putExtra("row", row_spinner.getSelectedItem().toString());
                    intent.putExtra("region", region);
                startActivity(intent);
                }catch(ourException e){
                    Toast.makeText( conditional_booking2a.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                }
            }
        });
            String[] row_big = new String[13+1];
            row_big[0]="請選擇排";
            row_big[1]="A";
            row_big[2]="B";
            row_big[3]="C";
            row_big[4]="D";
            row_big[5]="E";
            row_big[6]="F";
            row_big[7]="G";
            row_big[8]="H";
            row_big[9]="I";
            row_big[10]="J";
            row_big[11]="K";
            row_big[12]="L";
            row_big[13]="M";

            String[] row_small = new String[10+1];
            row_big[0]="請選擇排";
            row_big[1]="A";
            row_big[2]="B";
            row_big[3]="C";
            row_big[4]="D";
            row_big[5]="E";
            row_big[6]="F";
            row_big[7]="G";
            row_big[8]="H";
            row_big[9]="I";

            if("大廳".equals( Base.moviesList.get( Integer.parseInt(movieorder) ).determine_theater())){
            ArrayAdapter<String> rowList = new ArrayAdapter<>(conditional_booking2a.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    row_big);
            row_spinner.setSelection(0);
            row_spinner.setAdapter(rowList);
            }

            if("小廳".equals( Base.moviesList.get( Integer.parseInt(movieorder) ).determine_theater())){
                ArrayAdapter<String> rowList = new ArrayAdapter<>(conditional_booking2a.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        row_small);
                row_spinner.setSelection(0);
                row_spinner.setAdapter(rowList);
            }










    }catch (Exception e){
            Toast.makeText(conditional_booking2a.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
