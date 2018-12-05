package com.id.ac.ukdw.a2pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class dboard extends AppCompatActivity {

    private Button mEdit;
    private Button mShop;
    private Button mTopUp;
    private TextView mUsername;
    private TextView mSaldo;
    private TextView mPassword;
    private TextView mAlamat;
    private TextView mNama;
    private TextView mNoHp;
    private TextView mEmail;

    private User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dboard);

        mEdit = findViewById(R.id.btnEdit);
        mShop = findViewById(R.id.btnShop);
        mTopUp = findViewById(R.id.btnTopUp);
        mUsername = findViewById(R.id.txtUsername);
        mSaldo = findViewById(R.id.txtAmount);

        if( getIntent().getExtras() != null)
        {
            Intent i = getIntent();
            u = (User)i.getSerializableExtra("user");
            String text = "Welcome, " + u.getUsername();
            mUsername.setText(text);

            getDataUser(u.getUsername());
        }

        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEdit = new Intent(dboard.this, EditProfilePayment.class);
                iEdit.putExtra("user",u);
                startActivity(iEdit);
            }
        });

        mTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iTopUp = new Intent(dboard.this, TopupPayment.class);
                iTopUp.putExtra("user",u);
                startActivity(iTopUp);
            }
        });

        mShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShop = new Intent(dboard.this, ShopPayment.class);
                iShop.putExtra("user",u);
                startActivity(iShop);
            }
        });
    }

    public void getDataUser(String username){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("users").document(username);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);

                String text = "Amount : Rp " + user.getSaldo();
                mSaldo.setText(text);

                u = user;
            }
        });
    }
}
