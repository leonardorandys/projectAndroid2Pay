package com.id.ac.ukdw.a2pay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ShopPayment extends AppCompatActivity {

    private Button mP1;
    private Button mP2;
    private Button mP3;
    private Button mP4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_payment);

        mP1 = findViewById(R.id.btnPupuk1);
        mP2 = findViewById(R.id.btnPupuk2);
        mP3 = findViewById(R.id.btnPupuk3);
        mP4 = findViewById(R.id.btnPupuk4);



    }
}