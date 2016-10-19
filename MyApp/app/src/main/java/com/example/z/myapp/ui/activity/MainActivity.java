package com.example.z.myapp.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z.myapp.R;
import com.example.z.myapp.ui.adapter.IndexFragmentPagerAdapter;
import com.example.z.myapp.ui.fragment.IndexRecyclerFragment;
import com.example.z.myapp.ui.fragment.SettingFragment;
import com.example.z.myapp.ui.fragment.WeixinFragment;
import com.example.z.myapp.utils.MethodUtil;
import com.example.z.myapp.view.NoScrollViewPager;


public class MainActivity extends AppCompatActivity
{
    private Toolbar toolbar_index;
    private ViewGroup nav_bottom_first, nav_bottom_second,nav_bottom_third;
    private NoScrollViewPager indexPager;
    private TextView index_tv,city_tv,me_tv;
    private ImageView index_image,city_image,me_image;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        initViews();

        setSupportActionBar(toolbar_index);
        MethodUtil.getMethodUtil().systemBarColorUtil(this, R.color.colorPrimary);

    }

    private void initViews()
    {
        toolbar_index = (Toolbar)findViewById(R.id.toolbar_index);
        nav_bottom_first = (ViewGroup) findViewById(R.id.index_bottom_nav_first);
        nav_bottom_second = (ViewGroup) findViewById(R.id.index_bottom_nav_second);
        nav_bottom_third = (ViewGroup) findViewById(R.id.index_bottom_nav_third);
        indexPager = (NoScrollViewPager) findViewById(R.id.index_viewpager);
        index_tv = (TextView)nav_bottom_first.findViewById(R.id.index_nav_bottom_index_tv);
        city_tv = (TextView)nav_bottom_second.findViewById(R.id.index_nav_bottom_city_tv);
        me_tv = (TextView)nav_bottom_third.findViewById(R.id.index_nav_bottom_me_tv);
        index_image = (ImageView)nav_bottom_first.findViewById(R.id.index_nav_bottom_index_image);
        city_image = (ImageView)nav_bottom_second.findViewById(R.id.index_nav_bottom_city_image);
        me_image = (ImageView)nav_bottom_third.findViewById(R.id.index_nav_bottom_me_image);

        initAction();
    }

    private void initAction()
    {
        IndexFragmentPagerAdapter indexFragmentPagerAdapter = new IndexFragmentPagerAdapter(getSupportFragmentManager());
        indexFragmentPagerAdapter.addFragment(IndexRecyclerFragment.newInstance());
        indexFragmentPagerAdapter.addFragment(new WeixinFragment());
        indexFragmentPagerAdapter.addFragment(new SettingFragment());
        indexPager.setCanScrollble(false);
        indexPager.setAdapter(indexFragmentPagerAdapter);


        setTab(0);
        nav_bottom_first.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setSelect(0);
                setTab(0);

            }
        });
        nav_bottom_second.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setSelect(1);
                setTab(1);
            }
        });
        nav_bottom_third.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setSelect(2);
                setTab(2);
            }
        });


        indexPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                int currentItem = indexPager.getCurrentItem();
                switch(currentItem)
                {
                    case 0:
                        setTab(0);
                        break;
                    case 1:
                        setTab(1);
                        break;
                    case 2:
                        setTab(2);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }


    private void setSelect(int position)
    {
        indexPager.setCurrentItem(position);
    }

    private void setTab(int position)
    {
        index_tv.setTextColor(getResources().getColor(R.color.nav_bottom_normal));
        city_tv.setTextColor(getResources().getColor(R.color.nav_bottom_normal));
        me_tv.setTextColor(getResources().getColor(R.color.nav_bottom_normal));
        index_image.setImageResource(R.mipmap.shouye_off);
        city_image.setImageResource(R.mipmap.chengshi_off);
        me_image.setImageResource(R.mipmap.wode_off);

        switch (position)
        {
            case 0:
                index_tv.setTextColor(getResources().getColor(R.color.nav_bottom_select));
                index_image.setImageResource(R.mipmap.shouye_on);
                break;
            case 1:
                city_tv.setTextColor(getResources().getColor(R.color.nav_bottom_select));
                city_image.setImageResource(R.mipmap.chengshi_on);
                break;
            case 2:
                me_tv.setTextColor(getResources().getColor(R.color.nav_bottom_select));
                me_image.setImageResource(R.mipmap.wode_on);
                break;
            default:
                break;
        }
    }
}
