package com.example.z.myapp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;
import java.util.List;


public class IndexFragmentPagerAdapter extends FragmentPagerAdapter
{

    private List<Fragment> mFragments = new LinkedList<>();
    public IndexFragmentPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }


    @Override
    public Fragment getItem(int position)
    {
        return mFragments.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragments.size();
    }

    public void addFragment(Fragment fragment)
    {
        mFragments.add(fragment);
    }
}
