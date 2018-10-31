package com.somnus.preview.loader;

import android.content.Context;
import android.view.View;

import java.io.Serializable;

/**
 * Created by Somnus on 2018/10/31.
 * <p>
 * 使用自己的加载图片方式
 */

public interface ImageLoaderInterface<T extends View> extends Serializable {

    void loadImage(Context context, Object path, T imageView);
}
