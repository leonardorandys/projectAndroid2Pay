package com.id.ac.ukdw.a2pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditProfilePayment extends AppCompatActivity {

    private EditText mNama;
    private EditText mUsername;
    private EditText mPassword;
    private EditText mEmail;
    private EditText mAlamat;
    private EditText mNoHp;
    private Button mChange;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_payment);

        mChange = findViewById(R.id.btnChange);
        mNama = findViewById(R.id.edtNama);
        mUsername = findViewById(R.id.edtUsername);
        mPassword = findViewById(R.id.edtPassword);
        mEmail = findViewById(R.id.edtEmail);
        mAlamat = findViewById(R.id.edtAlamat);
        mNoHp = findViewById(R.id.edtNo);

        if( getIntent().getExtras() != null)
        {
            Intent i = getIntent();
            user = (User)i.getSerializableExtra("user");

            mNama.setText(user.getNama());
            mUsername.setText(user.getUsername());
            mPassword.setText(user.getPassword());
            mEmail.setText(user.getEmail());
            mAlamat.setText(user.getAlamat());
            mNoHp.setText(user.getNoHp());
//            mNama.setText(getIntent().getStringExtra("nama"));
//            mUsername.setText(getIntent().getStringExtra("username"));
//            mPassword.setText(getIntent().getStringExtra("password"));
//            mEmail.setText(getIntent().getStringExtra("email"));
//            mNoHp.setText(getIntent().getStringExtra("noHp"));
//            mAlamat.setText(getIntent().getStringExtra("alamat"));

        }

        mChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeProfile();
            }
        });
    }

    private void changeProfile(){
        String email = mEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(mUsername.getText().toString().isEmpty() ||
                mEmail.getText().toString().isEmpty()||
                mPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Field can't be empty", Toast.LENGTH_SHORT).show();
        }
        if (!email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
        }
        else
        {
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            User u = new User(mNama.getText().toString(), mUsername.getText().toString(), mPassword.getText().toString(), mEmail.getText().toString(), mAlamat.getText().toString(), mNoHp.getText().toString(), 0);

            db.collection("users").document(u.getUsername()).set(u);

            Toast.makeText(getApplicationContext(),"Changed successfully",Toast.LENGTH_SHORT).show();
            Intent iEdit = new Intent(EditProfilePayment.this, dboard.class);
            iEdit.putExtra("user", u);
            startActivity(iEdit);
        }
    }
}
