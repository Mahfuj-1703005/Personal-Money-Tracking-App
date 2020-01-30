package com.example.hisaab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class incomeGrid extends AppCompatActivity {

    private GridView gridView;
    String[] category;
    int[] image = {R.drawable.xa,R.drawable.xb,R.drawable.xc};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_grid);
        gridView = findViewById(R.id.grid2);
        category = getResources().getStringArray(R.array.incomeCategories);
        CustomAdapter adapter = new CustomAdapter(this,category,image);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(incomeGrid.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}