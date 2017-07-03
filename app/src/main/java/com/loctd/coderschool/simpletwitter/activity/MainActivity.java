package com.loctd.coderschool.simpletwitter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.loctd.coderschool.simpletwitter.R;
import com.loctd.coderschool.simpletwitter.adapters.HomePagerAdapter;
import com.loctd.coderschool.simpletwitter.application.RestApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabLayoutHome)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerHome)
    ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
