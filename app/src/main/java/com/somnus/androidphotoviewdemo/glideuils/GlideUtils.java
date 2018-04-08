package com.somnus.androidphotoviewdemo.glideuils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.somnus.androidphotoviewdemo.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


/**
 */
public class GlideUtils {
    static RequestOptions options = new RequestOptions()
            .placeholder(R.drawable.ic_default_error)
            .error(R.drawable.ic_default_error)
            .priority(Priority.HIGH);

    /**
     * 加载图片
     *
     * @param context
     * @param resources
     * @param imageView
     */
    public static void loadImage(Fragment context, Object resources, ImageView imageView) {

        Glide.with(context).load(R.drawable.ic_default_error)
                .load(resources)
                .apply(options)
                .into(imageView);
    }

    public static void loadImage(Activity context, Object resources, ImageView imageView) {
        Glide.with(context).load(R.drawable.ic_default_error)
                .load(resources)
                .apply(options)
                .into(imageView);
    }

    public static void loadImage(Context context, Object resources, ImageView imageView) {

        Glide.with(context).load(R.drawable.ic_default_error)
                .load(resources)
                .apply(options)
                .into(imageView);
    }

}
