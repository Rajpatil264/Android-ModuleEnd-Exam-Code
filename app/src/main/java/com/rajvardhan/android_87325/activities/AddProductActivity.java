package com.rajvardhan.android_87325.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rajvardhan.android_87325.R;
import com.rajvardhan.android_87325.entities.ElectronicStore;
import com.rajvardhan.android_87325.utils.DbHelper;

public class AddProductActivity extends AppCompatActivity {

    DbHelper dbHelper;
    EditText productId, productName, productCategory, productPrice;

    Button save, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productId = findViewById(R.id.productId);
        productName = findViewById(R.id.productName);
        productCategory = findViewById(R.id.productCategory);
        productPrice = findViewById(R.id.productPrice);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);

        dbHelper = new DbHelper(AddProductActivity.this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = productId.getText().toString();
                String name = productName.getText().toString();
                String category = productCategory.getText().toString();
                String price = productPrice.getText().toString();

                ElectronicStore store=new ElectronicStore(Integer.parseInt(id),name,category,price);
                dbHelper.insertProduct(store);
                Toast.makeText(AddProductActivity.this, "Product Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}