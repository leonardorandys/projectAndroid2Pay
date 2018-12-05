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

public class ProductDetailActivity extends AppCompatActivity {

    private TextView mProductName;
    private EditText mDescription;
    private EditText mQuantity;
    private TextView mPrice;
    private Button mBuy;
    private User u;
    private Product p = new Product();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        mProductName = findViewById(R.id.txtProductName);
        mDescription = findViewById(R.id.txtDesc);
        mPrice = findViewById(R.id.txtPrice);
        mQuantity = findViewById(R.id.txtQuantity);
        mBuy = findViewById(R.id.btnBuy);

        if( getIntent().getExtras() != null)
        {
            Intent i = getIntent();
            u = (User)i.getSerializableExtra("user");
            String pupuk = i.getStringExtra("pupuk");

            getDataProduct(pupuk);
        }

        mBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent iBuy = new Intent(ProductDetailActivity.this, dboard.class);

            int total = Integer.parseInt(mPrice.getText().toString().substring(3)) * Integer.parseInt(mQuantity.getText().toString());

            if(u.getSaldo() < total){
                Toast.makeText(getApplicationContext(),"Your amount is not enough",Toast.LENGTH_SHORT).show();
            }
            else{
                u.setSaldo((u.getSaldo() - total) - u.getSaldo());

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("users").document(u.getUsername()).set(u);

                Toast.makeText(getApplicationContext(),"Purchase successfull",Toast.LENGTH_SHORT).show();

                iBuy.putExtra("user", u);
                startActivity(iBuy);
            }
            }
        });
    }

    public void getDataProduct(String pupuk){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        p.setIdProduk(pupuk);
        DocumentReference docRef = db.collection("produk").document(pupuk);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                mProductName.setText(p.getIdProduk());

                p = documentSnapshot.toObject(Product.class);
                mDescription.setText(p.getDeskripsi());
                String harga = "Rp " + p.getHarga();
                mPrice.setText(harga);
            }
        });
    }
}
