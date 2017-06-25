package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class conditional_booking2 extends AppCompatActivity {
    private Button confirmation;
    private String number_sheets;
    private String movie;
    private String time;
    private String movieorder;
    private String continuity;
    private String assign;
    private String assignrow;
    private String row;
    private String region;

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
                intent.putExtra( "number_sheets", number_sheets );
                intent.putExtra( "movie", movie );
                intent.putExtra( "time", time );
                intent.putExtra( "movieorder", movieorder );
                intent.putExtra("continuity",continuity);
                intent.putExtra("assignrow", assignrow);
                intent.putExtra("assign", assign);
                intent.putExtra("row", row);
                startActivity(intent);
            }
        });
    }
}
