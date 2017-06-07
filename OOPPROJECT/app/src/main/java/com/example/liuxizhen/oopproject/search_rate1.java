package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class search_rate1 extends AppCompatActivity {
    private Button confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_rate1);
        confirmation = (Button) findViewById(R.id.confirmation);

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(search_rate1.this, search_rate2.class);
                startActivity(intent);
            }
        });
    }
}
