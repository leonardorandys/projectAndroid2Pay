package com.id.ac.ukdw.a2pay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {
    private Button btnClose;
    private Button btnEditAcc;
    private TextView txtUsername;
    private TextView txtTelepon;
    private TextView txtBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnClose = findViewById(R.id.btnClose);
        btnEditAcc = findViewById(R.id.btnEditAcc);
        txtUsername = findViewById(R.id.txtUsername);
        txtTelepon = findViewById(R.id.txtTelepon);
        txtBalance = findViewById(R.id.txtBalance);
    }
}
