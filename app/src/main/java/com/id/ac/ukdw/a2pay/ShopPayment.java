package com.id.ac.ukdw.a2pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopPayment extends AppCompatActivity {

    private Button mP1;
    private Button mP2;
    private Button mP3;
    private Button mP4;

    private User u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_payment);

        mP1 = findViewById(R.id.btnPupuk1);
        mP2 = findViewById(R.id.btnPupuk2);
        mP3 = findViewById(R.id.btnPupuk3);
        mP4 = findViewById(R.id.btnPupuk4);

        if( getIntent().getExtras() != null)
        {
            Intent i = getIntent();
            u = (User)i.getSerializableExtra("user");
        }

        mP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShop1 = new Intent(ShopPayment.this, ProductDetailActivity.class);
                iShop1.putExtra("user", u);

                iShop1.putExtra("pupuk","pupuk1");
                startActivity(iShop1);
            }
        });

        mP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShop1 = new Intent(ShopPayment.this, ProductDetailActivity.class);
                iShop1.putExtra("user", u);

                iShop1.putExtra("pupuk","pupuk2");
                startActivity(iShop1);
            }
        });

        mP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShop1 = new Intent(ShopPayment.this, ProductDetailActivity.class);
                iShop1.putExtra("user", u);

                iShop1.putExtra("pupuk","pupuk3");
                startActivity(iShop1);
            }
        });

        mP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShop1 = new Intent(ShopPayment.this, ProductDetailActivity.class);
                iShop1.putExtra("user", u);

                iShop1.putExtra("pupuk","pupuk4");
                startActivity(iShop1);
            }
        });
    }
}