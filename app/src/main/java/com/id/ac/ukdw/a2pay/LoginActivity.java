package com.id.ac.ukdw.a2pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = (Button) findViewById(R.id.btnLogin);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iLogin = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(iLogin);
            }
        });
    }
}
