package com.example.abdul.wishlistappv1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * Created by william on 29/11/16.
 */

public class CustomSwipeAdaptor1 extends PagerAdapter {
    private int[] image_resources = {R.drawable.bookseragon,R.drawable.brisingr,R.drawable.eldest,R.drawable.gobletoffire,R.drawable.halfblood,R.drawable.hpdeathly,R.drawable.nheritancecover};
    private Context ctx;
    private LayoutInflater LayoutInflater;

    public CustomSwipeAdaptor1(Context ctx)
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
        LayoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = LayoutInflater.inflate(R.layout.swipe_layout1,container,false);
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

