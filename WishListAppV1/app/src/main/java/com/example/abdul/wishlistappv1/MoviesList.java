package com.example.abdul.wishlistappv1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;




    public class MoviesList extends AppCompatActivity {

        ViewPager viewPager;
        CustomSwip  customSwip;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_movies_list);
            viewPager=(ViewPager)findViewById(R.id.viewPager);
            customSwip=new CustomSwip(this);
            viewPager.setAdapter(customSwip);
        }

    }