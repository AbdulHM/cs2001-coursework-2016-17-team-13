package com.example.abdul.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {
    ImageView imageView;
    TextView tx_movieName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        imageView=(ImageView) findViewById(R.id.movies_image);
        tx_movieName= (TextView) findViewById(R.id.movie_name);
        imageView.setImageResource(R.drawable.movies_icon);
        tx_movieName.setText("Name : "+getIntent().getStringExtra("FullName"));


    }
}
