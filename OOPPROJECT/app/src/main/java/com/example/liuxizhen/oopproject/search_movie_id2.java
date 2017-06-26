package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import basicMethod.Base;

public class search_movie_id2 extends AppCompatActivity {
    private Button confirmation;
    private TextView result;
    private  String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_movie_id2);
        confirmation = (Button) findViewById(R.id.confirmation);
        result = (TextView) findViewById(R.id.search_movie_ID_result) ;
        Bundle bundle = this.getIntent().getExtras();
        id=bundle.getString("movieid");

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean exist=false;
                for(int i=0;i<Base.moviesList.size();i++){
                    if(Base.moviesList.get(i).id==id){
                        exist=true;
                        break;
                    }
                }
                if(exist) {
                    Intent intent = new Intent();
                    intent.putExtra("directgoback", "true");
                    intent.setClass(search_movie_id2.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent();
                    intent.putExtra("directgoback", "true");
                    intent.setClass(search_movie_id2.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
