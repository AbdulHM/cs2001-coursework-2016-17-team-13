package com.example.ishraz.movie;

        import android.os.Bundle;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwip  customSwip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        customSwip=new CustomSwip(this);
        viewPager.setAdapter(customSwip);
    }

}