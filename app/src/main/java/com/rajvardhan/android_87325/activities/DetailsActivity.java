package com.rajvardhan.android_87325.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.rajvardhan.android_87325.R;
import com.rajvardhan.android_87325.entities.ElectronicStore;

public class DetailsActivity extends AppCompatActivity {

    TextView productId, productName, productCategory, productPrice;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        productId=findViewById(R.id.productId);
        productName=findViewById(R.id.productName);
        productCategory=findViewById(R.id.productCategory);
        productPrice=findViewById(R.id.productPrice);
        cancel=findViewById(R.id.cancel);

        Intent intent=getIntent();
        ElectronicStore obj=(ElectronicStore) intent.getSerializableExtra("productDetails");

        productId.setText("Product ID               : : "+obj.getPid()+"");
        productName.setText("Product Name       : : "+obj.getPname());
        productCategory.setText("Product Category : : "+obj.getCategory());
        productPrice.setText("Product Price        : : "+obj.getPrice());

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}