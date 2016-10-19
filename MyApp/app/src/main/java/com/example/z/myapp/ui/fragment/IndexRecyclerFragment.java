package com.example.z.myapp.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.z.myapp.R;
import com.example.z.myapp.entity.ImageDeal;
import com.example.z.myapp.ui.adapter.IndexRecyclerViewAdapter;

public class IndexRecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{

    private View rootView = null;
    private IndexRecyclerViewAdapter indexRecyclerViewAdapter;
    private SwipeRefreshLayout indexRefreshLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.index_recycler_popular_places,container,false);
        initBase();
        return rootView;
    }


    public static IndexRecyclerFragment newInstance()
    {
        IndexRecyclerFragment f = new IndexRecyclerFragment();
        return f;
    }
    private void initBase() {


        indexRefreshLayout = (SwipeRefreshLayout) this.rootView.findViewById(R.id.index_refresh);
        indexRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        indexRefreshLayout.setOnRefreshListener(this);

        indexRecyclerViewAdapter = new IndexRecyclerViewAdapter(getActivity());
        final RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.hot_places_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(indexRecyclerViewAdapter);

    }
    @Override
    public void onRefresh()
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {

                String img = "http://imgsrc.baidu.com/forum/w%3D580/sign=fcae01763b87e9504217f3642039531b/2f2eb9389b504fc29fccbeb0e4dde71191ef6df7.jpg";
                String [] images = new String []{img,img,img,img,img};
//                ImageDeal.setBanner_img1(img);
                ImageDeal.getImageDeal().setBanner_images(images);
                indexRecyclerViewAdapter.notifyDataSetChanged();

                indexRefreshLayout.setRefreshing(false);
//                indexRefreshLayout.setRefreshing(true);

                Toast.makeText(getContext(),"shuaxin" +ImageDeal.getBanner_img1(),Toast.LENGTH_SHORT).show();
            }
         }, 3000);
    }
}
