package com.somnus.androidphotoviewdemo;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author: Somnus
 * @Description: 图片加载工具类
 */
public class GlideUtils {
    /**
     * 加载普通的图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url)
                .placeholder(R.drawable.ic_default_error)
                .error(R.drawable.ic_default_error)
                .into(imageView);
    }

    /**
     * 加载本地图片
     *
     * @param context
     * @param resId
     * @param imgView
     */
    public static void loadImage(Context context, int resId, ImageView imgView) {
        Glide.with(context).load(resId)
                .placeholder(R.drawable.ic_default_error)
                .into(imgView);
    }

    public static void loadImageNoPlaPlace(Context context, int resId, ImageView imgView) {
        Glide.with(context).load(resId)
                .into(imgView);
    }


    /**
     * 加载有前缀的图片
     *
     * @param context
     * @param baseUrl   是否需要加图片前缀
     * @param url
     * @param imageView
     */
    public static RequestManager loadImage(Context context, boolean baseUrl, String url, ImageView imageView) {

        RequestManager mRequestManager = Glide.with(context);
        mRequestManager
                .load(url)
                .placeholder(R.drawable.ic_default_error)
                .into(imageView);
        return mRequestManager;
    }

    /**
     * 加载圆角的图片
     *
     * @param context
     * @param url
     * @param corner
     * @param imageView
     */
    public static void loadRoundedCorners(Context context, String url, int corner, ImageView imageView) {
        Glide.with(context).load(url).bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, corner, 0))
                .into(imageView);
    }

    /**
     * 加载圆形
     *
     * @param context
     * @param imgView
     */
    public static RequestManager loadCircleImage(Context context, String url, ImageView imgView) {
        RequestManager mRequestManager = Glide.with(context);
        mRequestManager
                .load(url)
                .placeholder(R.drawable.ic_default_error)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imgView);
        return mRequestManager;
    }

    /**
     * 设置模糊图片(默认方式)
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static RequestManager loadBlurImage(Context context, String url, ImageView imageView) {
        RequestManager mRequestManager = Glide.with(context);
        mRequestManager.load(url).bitmapTransform(new BlurTransformation(context)).into(imageView);
        return mRequestManager;
    }

    /**
     * 加载带圆角的模糊图片
     *
     * @param context
     * @param url
     * @param corner
     * @param imageView
     */
    public static RequestManager loadBlurImage(Context context, String url, int corner, ImageView imageView) {
        RequestManager mRequestManager = Glide.with(context);
        mRequestManager.load(url).bitmapTransform(new BlurTransformation(context), new RoundedCornersTransformation(context, corner, 0)).into(imageView);
        return mRequestManager;
    }

}
