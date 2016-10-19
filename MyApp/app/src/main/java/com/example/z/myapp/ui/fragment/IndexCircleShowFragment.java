package com.example.z.myapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.z.myapp.R;
import com.example.z.myapp.ui.adapter.IndexFragmentPagerAdapter;


public class IndexCircleShowFragment extends Fragment
{
    Context context;
    int pointIndex = 0;
    View view = null;
    ViewPager index_recycler_circler_show_viewpager;
    LinearLayout linearLayout;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.index_recycler_circler_show_item,container,false);
        linearLayout = (LinearLayout) view.findViewById(R.id.points);
        index_recycler_circler_show_viewpager = (ViewPager)view.findViewById(R.id.index_recycler_circler_show_viewpager);
        for(int i=0;i<3;i++)
        {
            //            设置圆圈点
            View view = new View(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);

            params.leftMargin = 20;
            view.setBackgroundResource(R.drawable.point_background);
            view.setLayoutParams(params);
            view.setEnabled(false);
            linearLayout.addView(view);
        }


        initAction();


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    /*
      * 初始化事件
      * */
    private void initAction()
    {
        ViewPager.OnPageChangeListener onPageChangeListener= new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                linearLayout.getChildAt(position).setEnabled(true);
                linearLayout.getChildAt(pointIndex).setEnabled(false);
//            更新标志位
                pointIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        index_recycler_circler_show_viewpager.setOnPageChangeListener(onPageChangeListener);
//        取中间数来作为起始位置
        int index = 0;
//        用来触发监听器
        index_recycler_circler_show_viewpager.setCurrentItem(index);
        linearLayout.getChildAt(pointIndex).setEnabled(true);
        IndexFragmentPagerAdapter indexFragmentPagerAdapter = new IndexFragmentPagerAdapter(getChildFragmentManager());
        indexFragmentPagerAdapter.addFragment(new TestFragment());
        indexFragmentPagerAdapter.addFragment(new TestFragment());
        indexFragmentPagerAdapter.addFragment(new TestFragment());
        index_recycler_circler_show_viewpager.setAdapter(indexFragmentPagerAdapter);
    }
}
