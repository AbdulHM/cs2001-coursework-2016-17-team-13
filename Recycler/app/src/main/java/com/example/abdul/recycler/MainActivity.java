package com.example.abdul.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> mediaNames = new ArrayList<>();
    ArrayCreator arrayCreator= new ArrayCreator();
    int Img_res= R.drawable.movies_icon;
    ArrayList<DataProvider> arrayList= new ArrayList<DataProvider>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        mediaNames= arrayCreator.createArray();
        int i=0;

        for (String name : mediaNames){

            DataProvider dataProvider= new DataProvider(Img_res, mediaNames.get(i));
            arrayList.add(dataProvider);
            i++;


        }
        adapter= new RecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }
}
