package com.example.hisaab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class gridview extends AppCompatActivity {

    private GridView gridView;
    String[] category;
    int[] image = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        gridView = findViewById(R.id.grid1);
        category = getResources().getStringArray(R.array.expenseCategories);
        CustomAdapter adapter = new CustomAdapter(this,category,image);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(gridview.this,expensetaker.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
