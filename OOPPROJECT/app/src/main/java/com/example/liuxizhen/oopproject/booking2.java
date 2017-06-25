package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import basicClass.*;
import basicMethod.Base;

public class booking2 extends AppCompatActivity {
    private Button confirmation;
    private EditText input_name;
    private EditText input_age;
    private String number_sheets;
    private String movie;
    private String time;
    private String movieorder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.booking2 );
            confirmation = (Button) findViewById( R.id.confirmation );
            input_name = (EditText) findViewById( R.id.input_name );
            input_age = (EditText) findViewById( R.id.input_age );

            Bundle bundle = this.getIntent().getExtras();

            number_sheets = bundle.getString( "number_sheets"  );
            movie = bundle.getString( "movie" );
            time = bundle.getString( "time" );
            movieorder = bundle.getString( "movieorder" );

            confirmation.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if ("".equals( input_name.getText().toString() ) ||
                                "".equals( input_age.getText().toString() )) {
                            throw new ourException( "有問題尚未回答" );
                        }
                        Intent intent = new Intent();
                        intent.setClass( booking2.this, booking3.class );
                        intent.putExtra( "number_sheets", number_sheets );
                        intent.putExtra( "movie", movie );
                        intent.putExtra( "time", time );
                        intent.putExtra( "name", input_name.getText().toString() );
                        intent.putExtra( "age", input_age.getText().toString() );
                        intent.putExtra( "movieorder", movieorder );
                        //把字串傳到第二個Activity
                        startActivity( intent );
                    } catch (ourException e) {
                        Toast.makeText( booking2.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                    }
                }
            } );
        }catch (Exception e){
            Toast.makeText(booking2.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}