package com.id.ac.ukdw.a2pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private Button mRegister;
    private EditText mNama;
    private EditText mUsername;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mAlamat;
    private EditText mNoHp;
    private EditText emailValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setAtribut();

        mRegister = (Button) findViewById(R.id.btnRegister);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRegister();
            }
        });
    }

    private void onClickRegister(){
        emailValidate = (EditText)findViewById(R.id.txtEmail);
        String email = emailValidate.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(mNama.getText().toString().isEmpty() ||
                mEmail.getText().toString().isEmpty()||
                mPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Field can't be empty", Toast.LENGTH_SHORT).show();
        }
        if (!email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"invalid email address",Toast.LENGTH_SHORT).show();
        }
        else
        {
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            User u = new User(mNama.getText().toString(), mUsername.getText().toString(), mPassword.getText().toString(), mEmail.getText().toString(), mAlamat.getText().toString(), mNoHp.getText().toString(), 0);

            db.collection("users").document(u.getUsername()).set(u);

            Toast.makeText(getApplicationContext(),"Register successfully",Toast.LENGTH_SHORT).show();
            Intent iRegister = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(iRegister);
        }
    }

    private void setAtribut(){
        mNama= findViewById(R.id.txtFullname);
        mAlamat = findViewById(R.id.txtAlamat);
        mEmail=findViewById(R.id.txtEmail);
        mNoHp = findViewById(R.id.txtNoHp);
        mPassword=findViewById(R.id.txtPassword);
        mRegister=findViewById(R.id.btnRegister);
        mUsername=findViewById(R.id.txtUsername);
    }

    private void startIntent(){
        Intent intent=new Intent(getApplicationContext(),DashboardActivity.class);
        startActivity(intent);
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
