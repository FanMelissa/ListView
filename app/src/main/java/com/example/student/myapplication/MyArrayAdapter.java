package com.example.student.myapplication;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class MyArrayAdapter extends ArrayAdapter<NhanVien> {

    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutid;

    public MyArrayAdapter(@NonNull Activity context, int textViewResourceId, ArrayList<NhanVien> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.layoutid = textViewResourceId;
        this.myArray = objects;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public NhanVien getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutid,null);

        if(myArray.size() > 0 && position >= 0){
            final TextView txtDisPlay = (TextView) convertView.findViewById(R.id.tv_item);
            final NhanVien nv = myArray.get(position);
            txtDisPlay.setText(nv.toString());
            final ImageView imgitem = (ImageView) convertView.findViewById(R.id.img_item);
            if(nv.isGender()){
                imgitem.setImageResource(R.drawable.nam);

            }
            else {
                imgitem.setImageResource(R.drawable.nu);
            }
        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
