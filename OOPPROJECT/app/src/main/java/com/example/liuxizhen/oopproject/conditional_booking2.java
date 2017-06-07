package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class conditional_booking2 extends AppCompatActivity {
    private Button confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditional_booking2);
        confirmation = (Button) findViewById(R.id.confirmation);

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(conditional_booking2.this, conditional_booking3.class);
                startActivity(intent);
            }
        });
    }
}
