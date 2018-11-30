package com.id.ac.ukdw.a2pay;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_dashboard);

//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.btm_nav);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.action_home :
//                        //Toast.makeText(BottomNavigationViewAction.this, "Home clicked", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.action_star :
//                        //Toast.makeText(BottomNavigationView.this, "Star clicked", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.action_money :
//                        //Toast.makeText(BottomNavigationView.this, "Money clicked", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.action_settings :
//                        //Toast.makeText(BottomNavigationView.this, "Settings clicked", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//
//                return true;
//            }
//        });

        super.onCreate(savedInstanceState);
    }

}
