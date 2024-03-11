package com.example.finalproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.finalproject.R;
import com.example.finalproject.databinding.ActivityMainBinding;
import com.example.finalproject.fragments.StaffCalendarFragment;
import com.example.finalproject.fragments.StaffHomeFragment;
import com.example.finalproject.fragments.StaffProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomTabActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        replaceFragment(new StaffHomeFragment());
        bottomNavigationView.getMenu().findItem(R.id.home_staff).setChecked(true);


        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home_staff) {
                replaceFragment(new StaffHomeFragment());
            } else if (id == R.id.calender_staff) {
                replaceFragment(new StaffCalendarFragment());
            }else if (id == R.id.profile_staff) {
                replaceFragment(new StaffProfileFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}