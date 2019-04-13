package com.example.quanlyhanghoa;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class ThongTin extends AppCompatActivity {
    android.support.v4.view.ViewPager ViewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        ViewPager=findViewById(R.id.ViewPager);
        ViewPager.setAdapter(new TabLayoutAdapter(getSupportFragmentManager()));
        tabLayout=findViewById(R.id.tabMode);
        tabLayout.setupWithViewPager(ViewPager);
    }
}
