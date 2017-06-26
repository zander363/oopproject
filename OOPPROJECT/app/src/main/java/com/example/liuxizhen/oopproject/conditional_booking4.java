package com.example.liuxizhen.oopproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import basicClass.User;
import basicClass.*;
import basicMethod.Base;

public class conditional_booking4 extends AppCompatActivity {
    private Button confirmation;
    private TextView conditional_booking_result;
    private String number_sheets;
    private String movie;
    private String time;
    private String movieorder;
    private String continuity;
    private String assign;
    private String assignrow;
    private String age;
    private String name;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.conditional_booking4);
            confirmation = (Button) findViewById(R.id.confirmation);
            conditional_booking_result = (TextView) findViewById((R.id.conditional_booking_result));
            context=getApplicationContext();
            OOPUser oopuser = new OOPUser(getApplicationContext());
            OOPTicket oopticket = new OOPTicket(getApplicationContext());

            User user=oopuser.get(name,Integer.parseInt(age));


            Bundle bundle = this.getIntent().getExtras();

            number_sheets = bundle.getString( "number_sheets" );
            movie = bundle.getString( "movie" );
            time = bundle.getString( "time" );
            name = bundle.getString( "name" );
            age = bundle.getString( "age" );
            movieorder = bundle.getString( "movieorder" );
            continuity = bundle.getString( "continuity" );
            assign = bundle.getString( "assign" );
            assignrow = bundle.getString( "assignrow" );

            confirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(conditional_booking4.this, MainActivity.class);
                    intent.putExtra("cannotgoback","yes");
                    intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                    startActivity(intent);
                }
            });
            if (Integer.parseInt( age) < Base.moviesList.get( Integer.parseInt( movieorder ) ).level) {
                switch (Base.moviesList.get( Integer.parseInt( movieorder ) ).level) {
                    case 6:
                        conditional_booking_result.setText( "失敗，該電影分級為保護級，" + age + "歲無法購買" );
                        break;
                    case 15:
                        conditional_booking_result.setText( "失敗，該電影分級為輔導級，" + age + "歲無法購買" );
                        break;
                    case 18:
                        conditional_booking_result.setText( "失敗，該電影分級為限制級，" + age + "歲無法購買" );
                        break;
                }
            }
            else {

                conditional_booking_result.setText(
                        "電影名稱：" + movie + "\n\n" +
                                "場次：" + time + "\n\n" +
                                "張數：" + number_sheets + "\n\n" +
                                "年齡：" + age + "\n\n" +
                                "名字：" + name + "\n"

                );

                if(Base.moviesList.get( Integer.parseInt( movieorder ) ).determine_theater()=="大廳")
                {Integer i;

                    OOPBigSeat oopBigSeat=new OOPBigSeat(context);

                    for(i=0;!oopBigSeat.get(i).occupied;i++){}

                    BigSeat b = oopBigSeat.get(i);

                Ticket a =new Ticket(user.id,b.seatid,Base.moviesList.get( Integer.parseInt( movieorder ) ).id,new ourtime(time));
                    oopticket.insert(a);
                }
                else{
                    Integer i;

                    OOPSmallSeat oopSmallSeat=new OOPSmallSeat(context);

                    for(i=0;!oopSmallSeat.get(i).occupied;i++){}

                    SmallSeat b = oopSmallSeat.get(i);

                    Ticket a =new Ticket(user.id,b.seatid,Base.moviesList.get( Integer.parseInt( movieorder ) ).id,new ourtime(time));
                    oopticket.insert(a);

                }



            }

        } catch (Exception e) {
            Toast.makeText(conditional_booking4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}