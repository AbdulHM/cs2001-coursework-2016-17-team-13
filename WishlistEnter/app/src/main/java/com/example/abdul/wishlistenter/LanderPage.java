package com.example.abdul.wishlistenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LanderPage extends AppCompatActivity {
    ImageView imageView;
    TextView tx_movieName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lander_page);
//        imageView=(ImageView) findViewById(R.id.movies_image);
        tx_movieName= (TextView) findViewById(R.id.movie_name);
//        imageView.setImageResource(R.drawable.movies_icon);
        tx_movieName.setText(getIntent().getStringExtra("name_id"));


    }
}
