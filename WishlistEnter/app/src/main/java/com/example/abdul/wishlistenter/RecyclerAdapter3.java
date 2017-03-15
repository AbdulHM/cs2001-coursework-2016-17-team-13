package com.example.abdul.wishlistenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Abdul on 26/02/2017.
 */

public class RecyclerAdapter3 extends RecyclerView.Adapter<RecyclerAdapter3.RecyclerViewHolder> {
    private ArrayList<DataProvider> dataProviders = new ArrayList<DataProvider>();
    Context ctx;

    public RecyclerAdapter3 (ArrayList<DataProvider> arrayList1, Context ctx){

        this.dataProviders= arrayList1;
        this.ctx=ctx;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder= new RecyclerViewHolder(view, ctx, dataProviders);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DataProvider dataprovider=  dataProviders.get(position);
        holder.imageView.setImageResource(dataprovider.getImg_res());
        holder.mediaName.setText(dataprovider.getMediaName());

    }

    @Override
    public int getItemCount() {
        return dataProviders.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView mediaName;
        ArrayList<DataProvider> dataProviders = new ArrayList<DataProvider>();
        Context ctx;
        MediaNames mediaNames= new MediaNames();
        ArrayList<String> tvList = new ArrayList<>();
        int Img_res= R.drawable.music_icon;


        public RecyclerViewHolder(View view, Context ctx, ArrayList<DataProvider> dataProviders  ){

            super(view);
            this.dataProviders= dataProviders;
            this.ctx=ctx;
            view.setOnClickListener(this);
            imageView= (ImageView) view.findViewById(R.id.media_icon);
            mediaName= (TextView) view.findViewById(R.id.media_name);
            try {
                tvList=  mediaNames.getNameList("television");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onClick(View v) {
            int position= getAdapterPosition();
//            DataProvider dataProvider= this.dataProviders.get(musiclist.get(position));
            DataProvider dataProvider= new DataProvider(Img_res, tvList.get(position));
            Intent intent= new Intent(this.ctx, LanderPage.class);
            intent.putExtra("name_id",dataProvider.getMediaName());
            this.ctx.startActivity(intent);




        }
    }
}

