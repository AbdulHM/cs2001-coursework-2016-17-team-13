package com.example.abdul.wishlistenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button advanceToMovies= (Button) findViewById(R.id.movies_button);
        advanceToMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMovies= new Intent(MainMenu.this, MoviesList.class);
                startActivity(openMovies);
            }
        });

        Button advanceToBooks= (Button) findViewById(R.id.books_button);
        advanceToBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openBooks= new Intent(MainMenu.this, BooksList.class);
                startActivity(openBooks);
            }
        });

        Button advanceToMusic= (Button) findViewById(R.id.music_button);
        advanceToMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMusic= new Intent(MainMenu.this, MusicList.class);
                startActivity(openMusic);
            }
        });
        Button advanceToTelevision= (Button) findViewById(R.id.tv_button);
        advanceToTelevision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTelevision= new Intent(MainMenu.this, TelevisionList.class);
                startActivity(openTelevision);
            }
        });





    }
}
