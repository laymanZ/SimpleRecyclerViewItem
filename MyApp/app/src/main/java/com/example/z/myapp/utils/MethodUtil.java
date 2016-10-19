package com.example.z.myapp.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MethodUtil
{
    private  SystemBarTintManager tintManager;

    private static MethodUtil methodUtil;

    public static MethodUtil getMethodUtil()
    {
        if(methodUtil == null)
            methodUtil = new MethodUtil();
        return methodUtil;
    }

    /*
        * 通知栏统一颜色，沉浸式
        * */
    public void systemBarColorUtil(Context context,int color)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP)
        {
//            下面这句话必须的
            getActivity(context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            tintManager = new SystemBarTintManager(getActivity(context));
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setTintResource(color);//通知栏所需颜色
        }
    }


    /*
    * 通过获取 context 获取activity
    * */
    private  Activity getActivity(Context context)
    {
        while(!(context instanceof Activity) && context instanceof ContextWrapper)
        {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if(context instanceof Activity)
        {
            return (Activity)context;
        }
        throw new ActivityNotFoundException("Unable to get Activity");
    }
}
