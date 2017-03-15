package com.example.abdul.wishlistenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class TelevisionList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> televisionList = new ArrayList<>();
    MediaNames mediaNames= new MediaNames();
    int Img_res= R.drawable.televison_icon;
    ArrayList<DataProvider> arrayList= new ArrayList<DataProvider>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        try {
            televisionList=  mediaNames.getNameList("television");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        int i=0;

        for (String name : televisionList){

            DataProvider dataProvider= new DataProvider(Img_res, televisionList.get(i));
            arrayList.add(dataProvider);
            i++;


        }
        adapter= new RecyclerAdapter3(arrayList, this);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }
}
