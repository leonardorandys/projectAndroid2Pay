package com.id.ac.ukdw.a2pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegister = (Button) findViewById(R.id.btnRegister);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iRegister = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(iRegister);
            }
        });
    }
}
