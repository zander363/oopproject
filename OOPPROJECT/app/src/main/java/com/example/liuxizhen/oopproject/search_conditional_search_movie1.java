package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class search_conditional_search_movie1 extends AppCompatActivity {
    private Button confirmation;
    private EditText editText;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private boolean ch2chk=false;
    private boolean ch3chk=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_conditional_search_movie1);
        confirmation = (Button) findViewById(R.id.confirmation);
        editText = (EditText) findViewById(R.id.editText);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox2.setOnClickListener((View.OnClickListener) chklistener);
        checkBox3.setOnClickListener((View.OnClickListener) chklistener);



        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!"".equals(editText.getText().toString())){
                    if(ch2chk||ch3chk) {
                        Intent intent = new Intent();
                        intent.setClass(search_conditional_search_movie1.this, search_conditional_search_movie2.class);
                        intent.putExtra("number_sheets", editText.getText().toString());

                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent();
                        intent.setClass(search_conditional_search_movie1.this, search_conditional_search_movie3.class);
                        intent.putExtra("number_sheets", editText.getText().toString());

                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(search_conditional_search_movie1.this,"有問題尚未回答", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    CheckBox.OnCheckedChangeListener chklistener = new CheckBox.OnCheckedChangeListener(){
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            if(checkBox2.isChecked()){
                ch2chk=true;
            }
            if(checkBox3.isChecked()){
                ch3chk=true;

            }

        }
    };
}



