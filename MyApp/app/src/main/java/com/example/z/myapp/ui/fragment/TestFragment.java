package com.example.z.myapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.example.z.myapp.R;

import java.util.ArrayList;
import java.util.HashMap;


public class TestFragment extends Fragment
{
    GridView gridView;

    int [] res = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,};


    String [] titles = {"1","2","3","4","5","6","7","8"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.grid,container,false);
        gridView = (GridView) view.findViewById(R.id.gridview);


        ArrayList<HashMap<String, Object>> item = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < res.length; i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", res[i]);
            map.put("itemName", titles[i]);
            item.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),item,R.layout.grid_content,
                new String[]{"itemImage","itemName"},new int[]{R.id.image,R.id.text});

        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),titles[position],Toast.LENGTH_SHORT).show();
            }
        });
        return  view;
    }
}
