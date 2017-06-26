package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class search_ticket2 extends AppCompatActivity {
    private Button confirmation;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_ticket2);
        confirmation = (Button) findViewById(R.id.confirmation);

        Bundle bundle = this.getIntent().getExtras();

        id = bundle.getString( "id" );

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("directgoback","true");
                intent.setClass(search_ticket2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
