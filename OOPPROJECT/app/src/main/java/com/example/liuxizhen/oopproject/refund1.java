package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class refund1 extends AppCompatActivity {
    private Button confirmation;
    private EditText input_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refund1);
        confirmation = (Button) findViewById(R.id.confirmation);
        input_ID = (EditText) findViewById(R.id.input_ID) ;

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(refund1.this, refund2.class);
                intent.putExtra("input_ID",input_ID.getText().toString());
                startActivity(intent);
            }
        });
    }
}
