package com.id.ac.ukdw.a2pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class TopupPayment extends AppCompatActivity {

    private Button mClaim;
    private Button mSend;
    private EditText mCode;
    private EditText mNominal;
    private EditText mNoTujuan;

    private User u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_payment);

        mClaim = findViewById(R.id.btnClaim);
        mSend = findViewById(R.id.btnSend);
        mCode = findViewById(R.id.edtCode);
        mNominal = findViewById(R.id.edtNominal);
        mNoTujuan = findViewById(R.id.edtNoTujuan);

        if( getIntent().getExtras() != null)
        {
            Intent i = getIntent();
            u = (User)i.getSerializableExtra("user");

        }

        mClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newSaldo = 0;
                String kode = mCode.getText().toString();
                if(kode.equals("IDR10"))
                    newSaldo = 10000;
                else if(kode.equals("IDR20"))
                    newSaldo = 20000;
                else if(kode.equals("IDR50"))
                    newSaldo = 50000;
                else if(kode.equals("IDR100"))
                    newSaldo = 100000;

                if(newSaldo > 0){
                    u.setSaldo(newSaldo);

                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                    db.collection("users").document(u.getUsername()).set(u);

                    Toast.makeText(getApplicationContext(),"Top up successfully",Toast.LENGTH_SHORT).show();

                    Intent iBoard = new Intent(TopupPayment.this, dboard.class);
                    iBoard.putExtra("user",u);
                    startActivity(iBoard);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid redeem code",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int newSaldo = Integer.parseInt(mNominal.getText().toString());
                String kode = mCode.getText().toString();
                if(Integer.parseInt(mNominal.getText().toString()) > 0){
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    CollectionReference users = db.collection("users");

                    // Create a query against the collection.
                    Query query = users.whereEqualTo("noHp",mNoTujuan.getText().toString());

                    //Toast.makeText(getApplicationContext(),query,Toast.LENGTH_SHORT).show();
                }
                if(u.getNoHp().equals(mNoTujuan.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Can't transfer to your own account",Toast.LENGTH_SHORT).show();
                }
                else if(newSaldo > u.getSaldo()){
                    Toast.makeText(getApplicationContext(),"Your amount is not enough",Toast.LENGTH_SHORT).show();
                }
                else if(newSaldo < 0){
                    Toast.makeText(getApplicationContext(),"Invalid nominal",Toast.LENGTH_SHORT).show();
                }
                else {
                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                    DocumentReference docRef = db.collection("index").document(mNoTujuan.getText().toString());
                    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            Index idx = documentSnapshot.toObject(Index.class);

                            FirebaseFirestore dbx = FirebaseFirestore.getInstance();

                            DocumentReference docRef = dbx.collection("users").document(idx.getUsername());
                            docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    User ux = documentSnapshot.toObject(User.class);

                                    ux.setSaldo(newSaldo);

                                    FirebaseFirestore dby = FirebaseFirestore.getInstance();
                                    dby.collection("users").document(ux.getUsername()).set(ux);
                                }

                            });

                            u.setSaldo((u.getSaldo() - newSaldo) - u.getSaldo());
                            dbx.collection("users").document(u.getUsername()).set(u);
                        }

                    });
                    Toast.makeText(getApplicationContext(),"Transfer successfully",Toast.LENGTH_SHORT).show();

                    Intent iBoard = new Intent(TopupPayment.this, dboard.class);
                    iBoard.putExtra("user",u);
                    startActivity(iBoard);
                }
            }
        });
    }
}