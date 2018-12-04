package com.id.ac.ukdw.a2pay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class dboard extends AppCompatActivity {

    private Button mAccount;
    private Button mEdit;
    private Button mShop;
    private TextView mUsername;
    private TextView mSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dboard);

        mAccount = findViewById(R.id.btnAccount);
        mEdit = findViewById(R.id.btnEdit);
        mShop = findViewById(R.id.btnShop);
        mUsername = findViewById(R.id.txtUsername);
        mSaldo = findViewById(R.id.txtAmount);

        if( getIntent().getExtras() != null)
        {
            String username = getIntent().getStringExtra("username");
            mUsername.setText("Hai, " + username);
        }

    }
}
