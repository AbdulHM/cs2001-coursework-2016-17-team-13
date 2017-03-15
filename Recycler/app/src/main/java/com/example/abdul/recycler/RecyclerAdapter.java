package com.example.abdul.recycler;

import android.content.Context;
import android.content.Intent;
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
    Context ctx;

    public RecyclerAdapter (ArrayList<DataProvider> arrayList, Context ctx){

        this.arrayList= arrayList;
        this.ctx= ctx;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder= new RecyclerViewHolder(view,ctx,arrayList);
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


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView mediaName;
        ArrayList<DataProvider> arrayList= new ArrayList<DataProvider>();
        Context ctx;



        public RecyclerViewHolder(View view,Context ctx,ArrayList<DataProvider> arrayList){

            super(view);
            this.arrayList= arrayList;
            this.ctx=ctx;
            view.setOnClickListener(this);
            imageView= (ImageView) view.findViewById(R.id.media_icon);
            mediaName= (TextView) view.findViewById(R.id.media_name);
        }

        @Override
        public void onClick(View v) {
//            int Img_res= R.drawable.movies_icon;
            int position =getAdapterPosition();
            DataProvider dataProvider= this.arrayList.get(position);
            Intent intent= new Intent(this.ctx, MovieDetails.class);
//            intent.putExtra("img_id",dataProvider.getImg_res());
            intent.putExtra("FullName", dataProvider.getMediaName());
            this.ctx.startActivity(intent);



        }
    }
}
