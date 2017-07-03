package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import basicClass.*;
import basicMethod.Base;

public class search_time2 extends AppCompatActivity {
    private Button confirmation;
    private String start;
    private String end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_time2);
        confirmation = (Button) findViewById(R.id.confirmation);
        TextView search_time_result=(TextView)findViewById(R.id.search_time_result);
        Bundle bundle = this.getIntent().getExtras();

        start = bundle.getString( "starttime" );
        end = bundle.getString( "endtime" );

        ArrayList<Movie> movies=new ArrayList<>();
        int i;
        if(start!=null){


            for(i=0; i< Base.moviesList.size(); i++){
                if(new ourtime(start)!=null){
                    movies.add(Base.moviesList.get(i));
                }
            }
        }
        if(end!=null){
            for(i=0; i< Base.moviesList.size(); i++) {
                if (new ourtime(end)!=null) {
                    movies.remove(i);
                }
            }
        }
        if(movies.size()>=0) {
            String text="";
            for(i=0; i< movies.size(); i++) {
                text += movies.get(i).moviename+"\n";
            }
            search_time_result.setText(text);
        }
        else{
            search_time_result.setText("查無此號");
        }


        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("directgoback","true");
                intent.setClass(search_time2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
