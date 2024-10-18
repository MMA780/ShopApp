package com.example.shop_app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shop_app.fragments.CartFragment;
import com.example.shop_app.fragments.HomeFragment;
import com.example.shop_app.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // تعریف یک Map برای نگاشت آیدی‌ها به فرگمنت‌ها
    private final Map<Integer, Fragment> fragmentMap = new HashMap<>();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // پر کردن Map با آیدی‌های ناوبری و فرگمنت‌های مربوطه
        fragmentMap.put(R.id.nav_home, new HomeFragment());
        fragmentMap.put(R.id.nav_cart, new CartFragment());
        fragmentMap.put(R.id.nav_profile, new ProfileFragment());

        // تنظیم Fragment پیش‌فرض
        loadFragment(fragmentMap.get(R.id.nav_home));

        // تنظیم BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = fragmentMap.get(item.getItemId());
            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }
            return true;
        });
    }

    // متدی برای جابجایی بین Fragment‌ها
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
