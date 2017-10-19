package com.exampledemo.parsaniahardik.imagesliderdemonuts;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.exampledemo.parsaniahardik.imagesliderdemonuts.model.SliderImageModel;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by infoava(nlk) .
 */
public class SlidingImage_Adapter extends PagerAdapter {

    private ArrayList<SliderImageModel> sliderImageArrayList;
    private LayoutInflater inflater;
    private Context context;

    public SlidingImage_Adapter(Context context, ArrayList<SliderImageModel> sliderImageArrayList) {
        this.context = context;
        this.sliderImageArrayList = sliderImageArrayList;
        inflater = LayoutInflater.from(context);
  }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return  sliderImageArrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);

        String url = "http://192.168.100.13:8080/Images/AdvertiseImage/4118129888812_slider3.png";
        //String url = "http://192.168.100.13:8080" +(sliderImageArrayList.get(position).getImagePath());
        Log.e("category","Error:+failure" + sliderImageArrayList.get(position).getImagePath());

        Picasso.with(context).load(url).into(imageView);

        //imageView.setImageResource(imageModelArrayList.get(position).getImage_drawable());

        view.addView(imageLayout, position);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override



    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}