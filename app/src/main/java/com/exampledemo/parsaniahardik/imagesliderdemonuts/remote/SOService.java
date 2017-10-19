package com.exampledemo.parsaniahardik.imagesliderdemonuts.remote;


import com.exampledemo.parsaniahardik.imagesliderdemonuts.model.CategoryModel;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.model.SliderImageModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by infoava(nlk) on 26/9/2017.
 */

public interface SOService {



    @GET("sliderImageList")
    Call<List<SliderImageModel>> getSliderImage();


    @GET("categoryList")
    Call<List<CategoryModel>> getCategory();


    @GET("categoryList")
    Call<List<CategoryModel>> getCategoryListView();

}
