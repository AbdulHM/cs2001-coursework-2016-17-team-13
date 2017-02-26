package com.example.abdul.recycler;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abdul on 25/02/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();

    public RecyclerAdapter (ArrayList<DataProvider> arrayList){

        this.arrayList= arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder= new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DataProvider dataprovider=  arrayList.get(position);
        holder.imageView.setImageResource(dataprovider.getImg_res());
        holder.mediaName.setText(dataprovider.getMediaName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView mediaName;


        public RecyclerViewHolder(View view){

            super(view);
            imageView= (ImageView) view.findViewById(R.id.media_icon);
            mediaName= (TextView) view.findViewById(R.id.media_name);
        }
    }
}
