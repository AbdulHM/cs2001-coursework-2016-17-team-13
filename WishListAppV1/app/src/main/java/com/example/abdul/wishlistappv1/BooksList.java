package com.example.abdul.wishlistappv1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BooksList extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdaptor1 adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adaptor = new CustomSwipeAdaptor1(this);
        viewPager.setAdapter(adaptor);
    }
}
