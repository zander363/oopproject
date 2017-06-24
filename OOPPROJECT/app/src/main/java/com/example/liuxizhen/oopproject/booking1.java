package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.*;
import basicMethod.*;
import basicClass.*;

public class booking1 extends AppCompatActivity {
    private Button confirmation;
    private Spinner movies_spinner;
    private Spinner time_spinner;
    private EditText number_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking1);

        confirmation = (Button) findViewById(R.id.confirmation);
        number_input = (EditText) findViewById(R.id.number_input);
        movies_spinner = (Spinner)findViewById(R.id.movies_spinner);
        time_spinner = (Spinner)findViewById(R.id.time_spinner);

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(booking1.this, booking2.class);

                intent.putExtra("number_sheets", number_input.getText().toString());
                intent.putExtra("movie", movies_spinner.getSelectedItem().toString());
                intent.putExtra("time", time_spinner.getSelectedItem().toString());
                //把字串傳到第二個Activity
                startActivity(intent);
            }
        });

        try{
        String[] movies = new String[Base.moviesList.length+1];
        movies[0]="請選擇電影";
        for(int i=0;i<Base.moviesList.length;i++){
            movies[i+1] = new String(Base.moviesList[i].moviename);
        }
        ArrayAdapter<String> movieList = new ArrayAdapter<>(booking1.this,
                android.R.layout.simple_spinner_dropdown_item,
                movies);
        movies_spinner.setSelection(0);
        movies_spinner.setAdapter(movieList);
        movies_spinner.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?>parent,View view,int position,long id){
                if (position>0) {
                    String[] time = new String[Base.moviesList[position-1].time.length+1];
                    time[0]="請選擇時間";
                    for (int i = 0; i < Base.moviesList[position-1].time.length; i++) {
                        time[i+1] = new String(Base.moviesList[position-1].time[i].getinfo());
                    }
                    ArrayAdapter<String> timeList = new ArrayAdapter<>(booking1.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            time);
                    time_spinner.setSelection(0);
                    time_spinner.setAdapter(timeList);
                }
                else{}
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }));
    }catch(Exception e){
            Toast.makeText(booking1.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

