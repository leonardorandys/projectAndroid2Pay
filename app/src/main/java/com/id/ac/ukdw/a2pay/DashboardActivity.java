package com.id.ac.ukdw.a2pay;

import android.accounts.AccountManagerCallback;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class DashboardActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, ShopFragment.OnFragmentInteractionListener, AccountFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.btm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_home:
                        loadFragment(new HomeFragment());
                        break;
                    case R.id.action_topup:
                        loadFragment(new ShopFragment());
                        break;
                    case R.id.action_account:
                        loadFragment(new AccountFragment());
                        break;
                    case R.id.action_settings:
                        loadFragment(new SettingsFragment());
                        break;
                }

                return true;
            }
        });
        // load the store fragment by default
        loadFragment(new HomeFragment());
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
