package com.example.relaxapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.relaxapp.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class UserGuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide);

        ViewPager viewPager = findViewById(R.id.view_pager);
        DotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);

        UserGuideImageViewAdapter viewAdapter = new UserGuideImageViewAdapter(this);
        viewPager.setAdapter(viewAdapter);
        dotsIndicator.setViewPager(viewPager);
    }
}