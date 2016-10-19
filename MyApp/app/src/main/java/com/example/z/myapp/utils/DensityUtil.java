package com.example.z.myapp.utils;

import android.content.Context;


public class DensityUtil
{
    /*
    * 根据手机分辨率将dp转换为px
    * */
    public static int dip2px(Context context,float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /*
    * 根据手机分辨率从px转换成dp
    * */
    public static int px2dip(Context context,float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
