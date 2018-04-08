package com.somnus.androidphotoviewdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

/**
 * Created by Somnus on 2018/4/8.
 */

public class UIHelper {
    /**
     * 有共享元素的跳转
     *
     * @param context
     * @param mIntent
     * @param view
     * @param shareName
     */
    public static void startActivityOption(Context context, Intent mIntent, View view, String shareName) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, view, shareName);
            context.startActivity(mIntent, options.toBundle());
        } else {
            context.startActivity(mIntent);
        }
    }

    /***
     * 多个元素的情况：
     *          Pair<View, String> pTitle = Pair.create(view,"title");
     *             Pair<View, String> pContent = Pair.create(view,"content");
     *             ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, mPair);
     * @param context
     * @param mIntent
     * @param mPair
     */

    public static void startActivityOptions(Context context, Intent mIntent, Pair<View, String>... mPair) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, mPair);
            context.startActivity(mIntent, options.toBundle());
        } else {
            context.startActivity(mIntent);
        }
    }

}
