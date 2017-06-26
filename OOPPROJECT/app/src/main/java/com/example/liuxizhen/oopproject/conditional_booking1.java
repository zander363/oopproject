package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import basicMethod.Base;


public class conditional_booking1 extends AppCompatActivity {
    private Button confirmation;
    private Spinner movies_spinner;
    private Spinner time_spinner;
    private EditText number_input;
    private CheckBox checkcontinue;
    private CheckBox checkassign;
    private CheckBox checkassignrow;
    private int movieorder;
    private String row="";
    private String region="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditional_booking1);
        confirmation = (Button) findViewById(R.id.confirmation);
        number_input = (EditText) findViewById(R.id.number_input);
        movies_spinner = (Spinner)findViewById(R.id.movies_spinner);
        time_spinner = (Spinner)findViewById(R.id.time_spinner);
        checkcontinue = (CheckBox) findViewById(R.id.checkcontinue);
        checkassign = (CheckBox)findViewById(R.id.checkassign);
        checkassignrow = (CheckBox)findViewById(R.id.checkassignrow);

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"請選擇電影".equals(movies_spinner.getSelectedItem().toString()) &&
                        !"請選擇場次".equals(time_spinner.getSelectedItem().toString()) &&
                        !"".equals(number_input.getText().toString())) {
                    if (checkassign.isChecked() || checkassignrow.isChecked()) {
                        if (checkassign.isChecked() && "小廳".equals( Base.moviesList.get( movieorder ).determine_theater())){
                            Toast.makeText(conditional_booking1.this, "小廳無區域", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if(checkassign.isChecked()){
                            Intent intent = new Intent();
                            intent.setClass(conditional_booking1.this, conditional_booking2.class);
                            intent.putExtra("number_sheets", number_input.getText().toString());
                            intent.putExtra("movie", movies_spinner.getSelectedItem().toString());
                            intent.putExtra("time", time_spinner.getSelectedItem().toString());
                            intent.putExtra("movieorder", Integer.toString(movieorder));
                            intent.putExtra("assign", checkassign.isChecked());
                            intent.putExtra("assignrow", checkassignrow.isChecked());
                            intent.putExtra("continuity", checkcontinue.isChecked());
                            //把字串傳到第二個Activity
                            startActivity(intent);}

                            else if(checkassignrow.isChecked()){
                                    Intent intent = new Intent();
                                    intent.setClass(conditional_booking1.this, conditional_booking2a.class);
                                    intent.putExtra("number_sheets", number_input.getText().toString());
                                    intent.putExtra("movie", movies_spinner.getSelectedItem().toString());
                                    intent.putExtra("time", time_spinner.getSelectedItem().toString());
                                    intent.putExtra("movieorder", Integer.toString(movieorder));
                                    intent.putExtra("assign", checkassign.isChecked());
                                    intent.putExtra("assignrow", checkassignrow.isChecked());
                                    intent.putExtra("continuity", checkcontinue.isChecked());
                                    //把字串傳到第二個Activity
                                    startActivity(intent);}

                    }} else {
                        Intent intent = new Intent();
                        intent.setClass(conditional_booking1.this, conditional_booking3.class);
                        intent.putExtra("number_sheets", number_input.getText().toString());
                        intent.putExtra("movie", movies_spinner.getSelectedItem().toString());
                        intent.putExtra("time", time_spinner.getSelectedItem().toString());
                        intent.putExtra("movieorder", Integer.toString(movieorder));
                        intent.putExtra("continue", checkcontinue.isChecked());
                        intent.putExtra("assignrow", checkassignrow.isChecked());
                        intent.putExtra("assign", checkassign.isChecked());
                        intent.putExtra("region", region);
                        intent.putExtra("row", row);
                        //把字串傳到第二個Activity
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(conditional_booking1.this, "有問題尚未回答", Toast.LENGTH_SHORT).show();
                }
            }
        });



        try{
            String[] movies = new String[Base.moviesList.size()+1];
            movies[0]="請選擇電影";
            for(int i=0;i<Base.moviesList.size();i++){
                movies[i+1] = new String(Base.moviesList.get(i).moviename);
            }
            ArrayAdapter<String> movieList = new ArrayAdapter<>(conditional_booking1.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    movies);
            movies_spinner.setSelection(0);
            movies_spinner.setAdapter(movieList);
            movies_spinner.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?>parent,View view,int position,long id){
                    if (position>0) {
                        movieorder = position-1;
                        String[] time = new String[Base.moviesList.get( movieorder ).time.length+1];
                        time[0]="請選擇場次";
                        for (int i = 0; i < Base.moviesList.get( movieorder ).time.length; i++) {
                            time[i+1] = new String( Base.moviesList.get( movieorder ).time[i].getinfo());
                        }
                        ArrayAdapter<String> timeList = new ArrayAdapter<>(conditional_booking1.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                time);
                        time_spinner.setSelection(0);
                        time_spinner.setAdapter(timeList);

                    }
                    else{
                        String[] time = new String[1];
                        time[0]="";
                        ArrayAdapter<String> timeList = new ArrayAdapter<>(conditional_booking1.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                time);
                        time_spinner.setSelection(0);
                        time_spinner.setAdapter(timeList);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    String[] time = new String[1];
                    time[0]="";
                    ArrayAdapter<String> timeList = new ArrayAdapter<>(conditional_booking1.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            time);
                    time_spinner.setSelection(0);
                    time_spinner.setAdapter(timeList);

                }
            }));
        }catch(Exception e){
            Toast.makeText(conditional_booking1.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
