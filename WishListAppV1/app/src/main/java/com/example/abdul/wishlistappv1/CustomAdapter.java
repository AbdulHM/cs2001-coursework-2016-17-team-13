package com.example.abdul.wishlistappv1;


import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdul.wishlistappv1.data.DataStore;
import com.example.abdul.wishlistappv1.data.DummyArrayBasedDataStore;
import com.example.abdul.wishlistappv1.data.Music;

import java.util.List;

/**
 * Created by ali_c on 05/12/2016.
 */

public class CustomAdapter extends PagerAdapter {

    Context context;
    DataStore dataStore;


    public CustomAdapter(Context context){
        this.context = context;
        dataStore = DummyArrayBasedDataStore.getInstance();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        List<Music> musicList = dataStore.getMusicRecommendations();

        Music music = musicList.get(position);

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.image_item, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView);
        imageView.setImageResource(music.getImage());
        TextView textView1 = (TextView) viewItem.findViewById(R.id.textView1);
        textView1.setText(music.getArtistDescription());
        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dataStore.getMusicRecommendations().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View)object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }
}