package com.example.buspass;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.buspass.ui.main.SectionsPagerAdapter;
import com.example.buspass.databinding.ActivityTabBinding;

public class tab_activity extends AppCompatActivity {

private ActivityTabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityTabBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPagers;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabLayouts;
        tabs.setupWithViewPager(viewPager);

    }
}