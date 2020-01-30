package com.example.hisaab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] image;
    String[] category;
    private LayoutInflater inflater;
    CustomAdapter(Context context,String[] category,int[] image){
        this.context = context;
        this.category = category;
        this.image = image;
    }
    @Override
    public int getCount() {
        return category.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample,parent,false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.images);
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        imageView.setImageResource(image[position]);
        textView.setText(category[position]);
        return convertView;
    }
}
