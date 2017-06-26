package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class search_movie_id1 extends AppCompatActivity {
    private Button confirmation;
    private EditText input_movie_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_movie_id1);
        confirmation = (Button) findViewById(R.id.confirmation);
        input_movie_ID=(EditText)findViewById(R.id.input_movie_ID);


        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search_movie_id1.this, search_movie_id2.class);
                intent.putExtra("movieid",input_movie_ID.getText().toString());
                startActivity(intent);
            }
        });
    }
}
