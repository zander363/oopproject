package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import basicClass.ourException;
import basicMethod.Base;

public class search_conditional_search_movie2 extends AppCompatActivity {
    private Button confirmation;
    private Spinner rowspinner;
    private Spinner regionspinner;
    private Boolean assignregion;
    private Boolean assignrow;
    private String number_sheets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_conditional_search_movie2);
        confirmation = (Button) findViewById(R.id.confirmation);
        rowspinner = (Spinner) findViewById( R.id. rowspinner);
        regionspinner = (Spinner) findViewById( R.id.regionspinner );


        Bundle bundle = this.getIntent().getExtras();
        number_sheets = bundle.getString( "number_sheets" );
        assignregion = bundle.getBoolean( "assignregion" );
        assignrow = bundle.getBoolean( "assignrow" );


        Toast.makeText(search_conditional_search_movie2.this, Boolean.toString( assignregion ) , Toast.LENGTH_LONG).show();


        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if ("請選擇排數".equals( rowspinner.getSelectedItem().toString() ) ||
                            "請選擇區域".equals( regionspinner.getSelectedItem().toString())) {
                        throw new ourException( "有問題尚未回答" );
                    }
                    Intent intent = new Intent();
                    intent.putExtra( "number_sheets", number_sheets );
                    intent.putExtra( "assignregion", assignregion );
                    intent.putExtra( "assignrow", assignrow );
                    intent.putExtra( "row", rowspinner.getSelectedItem().toString() );
                    intent.putExtra( "region", regionspinner.getSelectedItem().toString() );
                    intent.setClass( search_conditional_search_movie2.this, search_conditional_search_movie3.class );
                    startActivity( intent );
                }catch(ourException e){
                    Toast.makeText( search_conditional_search_movie2.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                }

            }
        });



        if(assignrow==true && assignregion==false){
            String[] row = new String[14];
            row[0]="請選擇排數";
            row[1]="A";
            row[2]="B";
            row[3]="C";
            row[4]="D";
            row[5]="E";
            row[6]="F";
            row[7]="G";
            row[8]="H";
            row[9]="I";
            row[10]="J(大廳)";
            row[11]="K(大廳)";
            row[12]="L(大廳)";
            row[13]="M(大廳)";

            String[] region = new String[1];
            region[0]="";


            ArrayAdapter<String> rowList = new ArrayAdapter<>(search_conditional_search_movie2.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    row);
            rowspinner.setSelection(0);
            rowspinner.setAdapter(rowList);


            ArrayAdapter<String> regionList = new ArrayAdapter<>(search_conditional_search_movie2.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    region);
            regionspinner.setSelection(0);
            regionspinner.setAdapter(regionList);


        }
        if(assignregion==true && assignrow==false){
            String[] row = new String[1];
            row[0]="";

            String[] region = new String[5];
            region[0]="請選擇區域";
            region[1]="紅";
            region[2]="黃";
            region[3]="藍";
            region[4]="灰";

            ArrayAdapter<String> rowList = new ArrayAdapter<>(search_conditional_search_movie2.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    row);
            rowspinner.setSelection(0);
            rowspinner.setAdapter(rowList);


            ArrayAdapter<String> regionList = new ArrayAdapter<>(search_conditional_search_movie2.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    region);
            regionspinner.setSelection(0);
            regionspinner.setAdapter(regionList);
        }
        else{
            String[] row = new String[14];
            row[0]="請選擇排數";
            row[1]="A";
            row[2]="B";
            row[3]="C";
            row[4]="D";
            row[5]="E";
            row[6]="F";
            row[7]="G";
            row[8]="H";
            row[9]="I";
            row[10]="J(大廳)";
            row[11]="K(大廳)";
            row[12]="L(大廳)";
            row[13]="M(大廳)";

            String[]  region = new String[5];
            region[0]="請選擇區域";
            region[1]="紅";
            region[2]="黃";
            region[3]="藍";
            region[4]="灰";

            ArrayAdapter<String> rowList = new ArrayAdapter<>(search_conditional_search_movie2.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    row);
            rowspinner.setSelection(0);
            rowspinner.setAdapter(rowList);


            ArrayAdapter<String> regionList = new ArrayAdapter<>(search_conditional_search_movie2.this,
                    android.R.layout.simple_spinner_dropdown_item,
                    region);
            regionspinner.setSelection(0);
            regionspinner.setAdapter(regionList);

        }


    }

}
