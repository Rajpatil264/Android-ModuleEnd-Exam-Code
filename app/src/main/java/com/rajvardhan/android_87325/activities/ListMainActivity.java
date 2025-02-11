package com.rajvardhan.android_87325.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.rajvardhan.android_87325.R;
import com.rajvardhan.android_87325.adapter.ElectronicAdapter;
import com.rajvardhan.android_87325.entities.ElectronicStore;
import com.rajvardhan.android_87325.utils.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class ListMainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    DbHelper dbHelper;

    ElectronicAdapter adapter;

    List<ElectronicStore> storeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recycleView);

        dbHelper= new DbHelper(ListMainActivity.this);
        storeList=new ArrayList<>();
        storeList=dbHelper.getAllProducts();
        adapter=new ElectronicAdapter(ListMainActivity.this,storeList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(ListMainActivity.this,1));
    }

    @Override
    protected void onStart() {
        super.onStart();
        dbHelper=new DbHelper(ListMainActivity.this);
        storeList=dbHelper.getAllProducts();
        adapter.setStoreList(storeList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Product").setIcon(R.drawable.add).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().equals("Add Product")){
            startActivity(new Intent(ListMainActivity.this,AddProductActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}