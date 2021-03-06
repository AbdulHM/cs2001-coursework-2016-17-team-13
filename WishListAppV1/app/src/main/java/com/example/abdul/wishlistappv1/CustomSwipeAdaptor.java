package com.example.abdul.wishlistappv1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by William on 02/12/16.
 */

public class CustomSwipeAdaptor extends PagerAdapter {
    private int[] image_resources = {R.drawable.fear_the_walking_dead,R.drawable.game_of_thrones,R.drawable.sons_of_anarchy,R.drawable.walking_dead};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdaptor(Context ctx)
    {
        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView)item_view.findViewById(R.id.image_view);
        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((LinearLayout)object);
    }

}
