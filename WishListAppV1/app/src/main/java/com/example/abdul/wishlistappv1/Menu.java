package com.example.abdul.wishlistappv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button advanceToMusic= (Button) findViewById(R.id.music_button);
        advanceToMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMusic= new Intent(Menu.this, MusicList.class);
                startActivity(openMusic);
            }
        });

        Button advanceToTV= (Button) findViewById(R.id.tv_button);
        advanceToTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTV= new Intent(Menu.this, TVList.class);
                startActivity(openTV);
            }
        });

        Button advanceToBooks= (Button) findViewById(R.id.books_button);
        advanceToBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openBooks= new Intent(Menu.this, BooksList.class);
                startActivity(openBooks);
            }
        });

        Button advanceToMovies= (Button) findViewById(R.id.movies_button);
        advanceToMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMovies= new Intent(Menu.this, MoviesList.class);
                startActivity(openMovies);
            }
        });
    }
}
