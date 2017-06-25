package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import basicClass.ourException;
import basicMethod.Base;

public class conditional_booking2 extends AppCompatActivity {
    private Button confirmation;
    private Spinner region_spinner;
    private String number_sheets;
    private String movie;
    private String time;
    private String movieorder;
    private String continuity;
    private String assign;
    private String assignrow;
    private String row;
    private String region;

    private UserDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.conditional_booking2a);
            confirmation = (Button) findViewById(R.id.confirmation);
            region_spinner = (Spinner)findViewById(R.id.region_spinner);

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
                        if (!"請選擇區域".equals(region_spinner.getSelectedItem().toString())) {
                            throw new ourException( "有問題尚未回答" );
                        }
                        if(Boolean.parseBoolean(assignrow)){
                        Intent intent = new Intent();
                        intent.setClass(conditional_booking2.this, conditional_booking2a.class);
                        intent.putExtra( "number_sheets", number_sheets );
                        intent.putExtra( "movie", movie );
                        intent.putExtra( "time", time );
                        intent.putExtra( "movieorder", movieorder );
                        intent.putExtra("continuity",continuity);
                        intent.putExtra("assignrow", assignrow);
                        intent.putExtra("assign", assign);
                        intent.putExtra("row", row);
                        intent.putExtra("region", region_spinner.getSelectedItem().toString());
                        startActivity(intent);}
                        else{
                            Intent intent = new Intent();
                            intent.setClass(conditional_booking2.this, conditional_booking3.class);
                            intent.putExtra( "number_sheets", number_sheets );
                            intent.putExtra( "movie", movie );
                            intent.putExtra( "time", time );
                            intent.putExtra( "movieorder", movieorder );
                            intent.putExtra("continuity",continuity);
                            intent.putExtra("assignrow", assignrow);
                            intent.putExtra("assign", assign);
                            intent.putExtra("row", row);
                            intent.putExtra("region", region_spinner.getSelectedItem().toString());
                            startActivity(intent);

                        }
                    }catch(ourException e){
                        Toast.makeText( conditional_booking2.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                    }
                }
            });
            String[] regions = new String[4+1];
            regions[0]="請選擇區域";
            regions[1]="紅";
            regions[2]="黃";
            regions[3]="藍";
            regions[4]="灰";




                ArrayAdapter<String> rowList = new ArrayAdapter<>(conditional_booking2.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        regions);
                region_spinner.setSelection(0);
                region_spinner.setAdapter(rowList);












        }catch (Exception e){
            Toast.makeText(conditional_booking2.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
