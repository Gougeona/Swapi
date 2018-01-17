package com.example.gougeoan.swapi.Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.gougeoan.swapi.Data.Film;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

public class AdapterListFilm extends BaseAdapter {
    ArrayList<Film> arrayList;
    Context c;

    public AdapterListFilm(Context c, ArrayList<Film> list) {
        arrayList = list;
        this.c = c;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row = null;
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            row = inflater.inflate(R.layout.list_item, parent,
                    false);
        } else {
            row = convertView;
        }
        String detail = arrayList.get(position).getTitle();

        TextView title = row.findViewById(R.id.title);
        title.setText(detail);

        return row;
    }

}