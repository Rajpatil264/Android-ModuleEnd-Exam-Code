package com.rajvardhan.android_87325.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajvardhan.android_87325.R;
import com.rajvardhan.android_87325.activities.DetailsActivity;
import com.rajvardhan.android_87325.entities.ElectronicStore;
import com.rajvardhan.android_87325.utils.DbHelper;

import java.util.List;

public class ElectronicAdapter extends RecyclerView.Adapter<ElectronicAdapter.MyViewHolder> {

    Context context;

    DbHelper dbHelper;
    List<ElectronicStore> storeList;

    public ElectronicAdapter(Context context, List<ElectronicStore> storeList) {
        this.context = context;
        this.storeList = storeList;
    }

    public void setStoreList(List<ElectronicStore> storeList) {
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.vh_list,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.productId.setText("Product ID        : : "+storeList.get(position).getPid()+"");
        holder.productName.setText("Product Name : : "+storeList.get(position).getPname());
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productId,productName;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productId=itemView.findViewById(R.id.productId);
            productName=itemView.findViewById(R.id.productName);
            imageView=itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, DetailsActivity.class);
                    intent.putExtra("productDetails",storeList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });

            dbHelper=new DbHelper(context);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.deleteProduct(storeList.get(getAdapterPosition()).getPid());
                    storeList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
