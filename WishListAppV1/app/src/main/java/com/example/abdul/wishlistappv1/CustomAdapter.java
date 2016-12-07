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

/**
 * Created by ali_c on 05/12/2016.
 */

public class CustomAdapter extends PagerAdapter {

    Context context;
    int[] imageId = {R.drawable.picture1, R.drawable.picture2, R.drawable.picture3, R.drawable.picture4, R.drawable.picture5, R.drawable.picture6, R.drawable.picture7,R.drawable.picture8,R.drawable.picture9 };
    String[] ArtistDescription = {"Come see Britney Spears live ! with WhatILike tickets. Go to www.whatIlike.co.uk","Come see Drake live ! with WhatILike tickets. Go to www.whatIlike.co.uk ","Come see Hannah Montana live ! with WhatILike tickets. Go to www.whatIlike.co.uk ", "Come see JCole Live! With WhatILike tickets Go to www.whatilike.com","Come see John Legend Live! With WhatILike tickets  Go to www.whatilike.com",
            "Come see Justin Beiber  Live! Go to www.whatilike.com", "Come see Kanye West Live! Go to www.whatilike.com" ,"Come see Lana Del Rey live ! With WhatILike tickets" ,"Come see Maroon 5 Live! Go to www.whatilike.com"};
    public CustomAdapter(Context context){
        this.context = context;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.image_item, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView);
        imageView.setImageResource(imageId[position]);
        TextView textView1 = (TextView) viewItem.findViewById(R.id.textView1);
        textView1.setText(ArtistDescription[position]);
        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageId.length;
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