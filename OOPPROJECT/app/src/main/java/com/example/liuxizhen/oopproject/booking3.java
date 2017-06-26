package com.example.liuxizhen.oopproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import basicClass.*;


import basicMethod.Base;

public class booking3 extends AppCompatActivity {
    private Button confirmation;
    private TextView booking_result;
    private String number_sheets;
    private String movie;
    private String time;
    private String age;
    private String name;
    private String movieorder;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.booking3 );
            confirmation = (Button) findViewById( R.id.confirmation );
            booking_result = (TextView) findViewById( R.id.booking_result );
            context=getApplicationContext();
            OOPUser oopuser = new OOPUser(getApplicationContext());
            OOPTicket oopticket = new OOPTicket(getApplicationContext());

            Bundle bundle = this.getIntent().getExtras();
            number_sheets = bundle.getString( "number_sheets" );
            movie = bundle.getString( "movie" );
            time = bundle.getString( "time" );
            name = bundle.getString( "name" );
            age = bundle.getString( "age" );
            movieorder = bundle.getString( "movieorder" );

            User user=oopuser.get(name,Integer.parseInt(age));
            //User user=oopuser.getAll().get(0);
            //Ticket(user.id,time)

            //oopticket.insert();


            confirmation.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass( booking3.this, MainActivity.class );
                    intent.putExtra("cannotgoback","yes");
                    intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                    startActivity( intent );
                }
            } );
            if (user.age < Base.moviesList.get( Integer.parseInt( movieorder ) ).level) {
                switch (Base.moviesList.get( Integer.parseInt( movieorder ) ).level) {
                    case 6:
                        booking_result.setText( "失敗，該電影分級為保護級，" + age + "歲無法購買" );
                        break;
                    case 15:
                        booking_result.setText( "失敗，該電影分級為輔導級，" + age + "歲無法購買" );
                        break;
                    case 18:
                        booking_result.setText( "失敗，該電影分級為限制級，" + age + "歲無法購買" );
                        break;
                }
            }
            else {

                booking_result.setText(
                        "電影名稱：" + movie + "\n\n" +
                                "場次：" + time + "\n\n" +
                                "張數：" + number_sheets + "\n\n" +
                                "年齡：" + user.age + "\n\n" +
                                "名字：" + user.name + "\n"

                );

                if(Base.moviesList.get( Integer.parseInt( movieorder ) ).determine_theater()=="大廳")
                {Integer i;

                    OOPBigSeat oopBigSeat=new OOPBigSeat(context,new ourtime(time),Base.moviesList.get( Integer.parseInt( movieorder ) ).moviename);

                    for(i=0;!oopBigSeat.get(i).occupied;i++){}

                    BigSeat b = oopBigSeat.get(i);

                    Ticket a =new Ticket(user.id,b.seatid,Base.moviesList.get( Integer.parseInt( movieorder ) ).id,new ourtime(time));
                    oopticket.insert(a);
                }
                else{
                    Integer i;

                    OOPSmallSeat oopSmallSeat=new OOPSmallSeat(context,new ourtime(time),Base.moviesList.get( Integer.parseInt( movieorder ) ).moviename);

                    for(i=0;!oopSmallSeat.get(i).occupied;i++){}

                    SmallSeat b = oopSmallSeat.get(i);

                    Ticket a =new Ticket(user.id,b.seatid,Base.moviesList.get( Integer.parseInt( movieorder ) ).id,new ourtime(time));
                    oopticket.insert(a);

                }


            }

        }catch(Exception e){
            Toast.makeText(booking3.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setClass(booking3.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
