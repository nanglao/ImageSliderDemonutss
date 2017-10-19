package com.exampledemo.parsaniahardik.imagesliderdemonuts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.BestDeal_Details;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.R;

import java.util.List;

/**
 * Created by infoava on 10/12/2017.
 */

public class BestDeal_SeeMore_Adapter extends RecyclerView.Adapter<BestDeal_SeeMore_Adapter.MyViewHolder>  {

    private List<BestDeal_Details> bestDealList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtproductName, txtCity,txtOrder,txtprice,txtsold;
        public ImageView imgBestDealList;
        public ImageButton imgDetail;

        public MyViewHolder(View view) {
            super(view);
            txtproductName = (TextView)view.findViewById(R.id.txtproductName);
            txtCity = (TextView)view.findViewById(R.id.txtCity);
            txtOrder = (TextView)view.findViewById(R.id.txtOrder);
            txtprice = (TextView)view.findViewById(R.id.txtprice);
            txtsold = (TextView)view.findViewById(R.id.txtsold);
            imgBestDealList = (ImageView)view.findViewById(R.id.imgBestDealList);
            imgDetail = (ImageButton)view.findViewById(R.id.imgDetail);
        }
    }

    @Override
    public BestDeal_SeeMore_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bestdeal_card_view, parent, false);
        return new BestDeal_SeeMore_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BestDeal_SeeMore_Adapter.MyViewHolder holder, int position) {
        BestDeal_Details bestDealLists = bestDealList.get(position);
        holder.txtproductName.setText(bestDealLists.getProductName());
        holder.txtCity.setText(bestDealLists.getCity());
        holder.txtOrder.setText("Minimum Order"+bestDealLists.getQantityOrder());
        holder.txtsold.setText(bestDealLists.getQantitySolds());
        holder.txtprice.setText("Ks- "+bestDealLists.getPrice());
       holder.imgDetail.setImageResource(bestDealLists.getProductImg());
    }

    @Override
    public int getItemCount() {
        return bestDealList.size();
    }
}


