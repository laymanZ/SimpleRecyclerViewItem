package com.example.z.myapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.z.myapp.R;


public class IndexRecommendFragment extends Fragment
{
    View view = null;
    Context context;
    TextView recommend_more;
    ImageView recommend_more_image,recommend_first_image,
            recommend_second_image,recommend_third_image,recommend_forth_image;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.index_recycler_recommend_item,container,false);



        initAction();
        return view;
    }

    private void initAction()
    {
        context = getActivity().getApplicationContext();
        recommend_more = (TextView)view.findViewById(R.id.recommend_more);
        recommend_more_image = (ImageView)view.findViewById(R.id.recommend_more_img);
        recommend_first_image = (ImageView)view.findViewById(R.id.recommend_first_image);
        recommend_second_image = (ImageView)view.findViewById(R.id.recommend_second_image);
        recommend_third_image = (ImageView)view.findViewById(R.id.recommend_third_image);
        recommend_forth_image = (ImageView)view.findViewById(R.id.recommend_forth_image);
        Glide.with(context).load("http://pic3.nipic.com/20090518/2392769_112120026_2.jpg").into(recommend_first_image);
        Glide.with(context).load("http://02.imgmini.eastday.com/mobile/20160503/20160503033158_f9467d8a67908802acb08e11270b48cb_3.jpeg").into(recommend_second_image);
        Glide.with(context).load("http://02.imgmini.eastday.com/mobile/20160503/20160503033158_f9467d8a67908802acb08e11270b48cb_3.jpeg").into(recommend_third_image);
        Glide.with(context).load("http://02.imgmini.eastday.com/mobile/20160503/20160503033158_f9467d8a67908802acb08e11270b48cb_3.jpeg").into(recommend_forth_image);


    }
}
