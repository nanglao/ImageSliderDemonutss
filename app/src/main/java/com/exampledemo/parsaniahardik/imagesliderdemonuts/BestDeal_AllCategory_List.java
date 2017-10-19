package com.exampledemo.parsaniahardik.imagesliderdemonuts;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by infoava(nlk) on 10/12/2017.
 */

public class BestDeal_AllCategory_List extends AppCompatActivity {

    ListView listCategory;
    // Array of strings...
    String[] AllCategoryArray = {"All Category","Women's Fashion","Men's Fashion","Bags & Shoes",
            "Consumer Electonics","Consumer Electronics","Home & Garden Accessories","Furniture","Phones & Accessories",
            "Sports & Outdoors","Toys,Kids & Baby","Automobiles & Motorcycles","Health & Beauty,Hair","Home Improment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_listview);


        listCategory = (ListView)findViewById(R.id.categorylist);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.category_listview_details, R.id.txtAllCategorylist, AllCategoryArray);
        listCategory.setAdapter(adapter);
}
}

