package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.*;

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

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(booking1.this, booking2.class);
                startActivity(intent);
                intent.putExtra("number_sheets", number_input.getText().toString());
                intent.putExtra("movie", movies_spinner.getSelectedItem().toString());
                intent.putExtra("time", time_spinner.getSelectedItem().toString());
                //把字串傳到第二個Activity
                startActivity(intent);
            }
        });

        movies_spinner = (Spinner)findViewById(R.id.movies_spinner);
        String[] movies = {"黑子的籃球", "魯肉飯", "排骨飯", "水餃", "陽春麵"};
        ArrayAdapter<String> movieList = new ArrayAdapter<>(booking1.this,
                android.R.layout.simple_spinner_dropdown_item,
                movies);
        movies_spinner.setAdapter(movieList);

        time_spinner = (Spinner)findViewById(R.id.time_spinner);
        String[] time = {"13:00", "魯肉飯", "排骨飯", "水餃", "陽春麵"};
        ArrayAdapter<String> timeList = new ArrayAdapter<>(booking1.this,
                android.R.layout.simple_spinner_dropdown_item,
                time);
        time_spinner.setAdapter(timeList);

    }
}

