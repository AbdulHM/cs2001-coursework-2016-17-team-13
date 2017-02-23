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
    }
}
