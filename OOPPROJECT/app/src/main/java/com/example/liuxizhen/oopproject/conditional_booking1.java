package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class conditional_booking1 extends AppCompatActivity {
    private Button confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditional_booking1);
        confirmation = (Button) findViewById(R.id.confirmation);

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(conditional_booking1.this, conditional_booking2.class);
                startActivity(intent);
            }
        });
    }
}
