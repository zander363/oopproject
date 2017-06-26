package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class search_conditional_search_movie2 extends AppCompatActivity {
    private Button confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_conditional_search_movie2);
        confirmation = (Button) findViewById(R.id.confirmation);


        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search_conditional_search_movie2.this, search_conditional_search_movie3.class);
                startActivity(intent);
            }
        });
    }
}
