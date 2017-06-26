package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import basicMethod.Base;


public class search_rate2 extends AppCompatActivity {
    private Button confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_rate2);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(search_rate1.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("評分高於"+message);
        ArrayList<basicClass.Movie> movies=new ArrayList<>();
        confirmation = (Button) findViewById(R.id.confirmation); boolean exist=false;
        double r=Double.parseDouble(message);
        int i;
        for(i=0; i< Base.moviesList.size(); i++){

            if(Base.moviesList.get(i).rate>r){
                movies.add(Base.moviesList.get(i));
            }
        }
        if(movies.size()>=0) {
            String text="";
            for(i=0; i< movies.size(); i++) {
                text += movies.get(i).moviename+"\n";
            }
            textView.setText(text);
        }
        else{
            textView.setText("查無此號");
        }

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("directgoback","true");
                intent.setClass(search_rate2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
