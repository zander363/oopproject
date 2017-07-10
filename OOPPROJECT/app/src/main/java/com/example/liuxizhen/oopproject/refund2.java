package com.example.liuxizhen.oopproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import basicMethod.*;

public class refund2 extends AppCompatActivity {
    private Button confirmation;
    private TextView refund_result;
    private String input_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refund2);
        confirmation = (Button) findViewById(R.id.confirmation);
        refund_result = (TextView) findViewById(R.id.refund_result);

        Bundle bundle = this.getIntent().getExtras();
        input_ID = bundle.getString("input_ID");


        switch(BookAndRefund.refundReportCode(input_ID)){
            case 0:
                refund_result.setText("退票成功");
                break;
            case 1:
                refund_result.setText("電影將於20分鐘內上映，恕無法退票");
                break;
            case 2:
                refund_result.setText("查無此票卡");

        }

        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(refund2.this, MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setClass(refund2.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
