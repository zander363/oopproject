package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class search extends AppCompatActivity {
    private ImageButton time ;
    private ImageButton rate ;
    private ImageButton ticket ;
    private ImageButton conditional_search_movie ;
    private ImageButton movie_ID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        time = (ImageButton) findViewById(R.id.time);
        rate = (ImageButton) findViewById(R.id.rate);
        ticket = (ImageButton) findViewById(R.id.ticket);
        conditional_search_movie = (ImageButton) findViewById(R.id.conditional_search_movie);
        movie_ID = (ImageButton) findViewById(R.id.movie_id);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search.this, search_time1.class);
                startActivity(intent);
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search.this, search_rate1.class);
                startActivity(intent);
            }
        });

        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search.this, search_ticket1.class);
                startActivity(intent);
            }
        });

        conditional_search_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search.this, search_conditional_search_movie1.class);
                startActivity(intent);
            }
        });

        movie_ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search.this, search_movie_id1.class);
                startActivity(intent);
            }
        });



    }
}
