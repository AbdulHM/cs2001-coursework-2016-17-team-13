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

public class BooksList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> booksList = new ArrayList<>();
    MediaNames mediaNames= new MediaNames();
    int Img_res= R.drawable.books_icon;
    ArrayList<DataProvider> arrayList= new ArrayList<DataProvider>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        try {
            booksList=  mediaNames.getNameList("books");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        int i=0;

        for (String name : booksList){

            DataProvider dataProvider= new DataProvider(Img_res, booksList.get(i));
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
