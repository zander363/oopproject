package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import basicClass.User;

public class search_conditional_search_movie3 extends AppCompatActivity {
    private Button confirmation;
    private String number_sheets;
    private String assign;
    private String assignrow;
    private String row;
    private String region;
    private TextView conditional_search_movie_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.search_conditional_search_movie3 );
            confirmation = (Button) findViewById( R.id.confirmation );
            conditional_search_movie_result = (TextView) findViewById( R.id.conditional_search_movie_result );

            Bundle bundle = this.getIntent().getExtras();
            number_sheets = bundle.getString( "number_sheets" );
            assign = bundle.getString( "assignregion" );
            assignrow = bundle.getString( "assignrow" );
            row=bundle.getString("row");
            region=bundle.getString("region");

            OOPUser oopuser = new OOPUser( getApplicationContext() );
            OOPTicket oopticket = new OOPTicket( getApplicationContext() );



            conditional_search_movie_result.setText( "" );

            confirmation.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra( "directgoback", "true" );
                    intent.setClass( search_conditional_search_movie3.this, MainActivity.class );
                    startActivity( intent );
                }
            } );

    }catch(Exception e){
        Toast.makeText(search_conditional_search_movie3.this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
}
