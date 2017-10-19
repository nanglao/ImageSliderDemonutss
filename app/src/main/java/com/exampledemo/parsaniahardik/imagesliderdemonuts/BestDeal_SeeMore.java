package com.exampledemo.parsaniahardik.imagesliderdemonuts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.adapter.BestDeal_SeeMore_Adapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoava on 10/11/2017.
 */

public class BestDeal_SeeMore extends AppCompatActivity {

    Button btnAllCategory;

    RecyclerView rvBestDeal;
    RecyclerView.LayoutManager layoutManager;
    private List<BestDeal_Details> BestDealList;
    private BestDeal_SeeMore_Adapter bdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bestdeal_seemore);


        btnAllCategory = (Button)findViewById(R.id.btnAllCategory);
        btnAllCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentALlCategory = new Intent(getApplicationContext(),BestDeal_AllCategory_List.class);
                startActivity(intentALlCategory);

            }
        });

        rvBestDeal = (RecyclerView)findViewById(R.id.rvBestDeal);

        BestDealList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        rvBestDeal.setLayoutManager(layoutManager);

        rvBestDeal.setAdapter(bdAdapter);
        prepareAllCategory();

    }

    /**
     * Adding few albums for card view image
     */
    private void prepareAllCategory() {
        int[] allCategory = new int[]{
                R.drawable.pho1,
                R.drawable.pho2,
                R.drawable.pho3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10};

        BestDeal_Details a = new BestDeal_Details("Ks-240,000","Ks-240,000", allCategory[0],20,20,20);
        BestDealList.add(a);

        a = new BestDeal_Details("Ks-240,000","Ks-240,000", allCategory[0],20,20,20);
        BestDealList.add(a);


    }

}
