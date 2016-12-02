package com.example.abdul.wishlistappv1;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TVList extends AppCompatActivity {


    ViewPager viewPager;
    CustomSwipeAdaptor adaptor;

    public Button homebutton;

    public void homeButton(){
        homebutton= (Button)findViewById(R.id.homeButton);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(TVList.this,Menu.class);

                startActivity(home);
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvlist);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adaptor = new CustomSwipeAdaptor(this);
        viewPager.setAdapter(adaptor);
        homeButton();
    }
}
