package com.somnus.androidphotoviewdemo;


import com.somnus.preview.IPreviewUrl;

import java.io.Serializable;

/**
 * ================================================
 * 作    者： Somnus
 * 版    本： V1.0
 * 创建日期： 2018年4月8日14:30:06
 * 描    述：实现 IPreviewUrl getThumbnailUrl
 * 修订历史：
 * ================================================
 */
public class ImageInfo implements Serializable, IPreviewUrl {
    public String getImagUrl() {
        return imagUrl;
    }

    public void setImagUrl(String imagUrl) {
        this.imagUrl = imagUrl;
    }


    public String imagUrl;
    public int imageViewHeight;
    public int imageViewWidth;
    public int imageViewX;
    public int imageViewY;


    public int getImageViewHeight() {
        return imageViewHeight;
    }

    public void setImageViewHeight(int imageViewHeight) {
        this.imageViewHeight = imageViewHeight;
    }

    public int getImageViewWidth() {
        return imageViewWidth;
    }

    public void setImageViewWidth(int imageViewWidth) {
        this.imageViewWidth = imageViewWidth;
    }

    public int getImageViewX() {
        return imageViewX;
    }

    public void setImageViewX(int imageViewX) {
        this.imageViewX = imageViewX;
    }

    public int getImageViewY() {
        return imageViewY;
    }

    public void setImageViewY(int imageViewY) {
        this.imageViewY = imageViewY;
    }


    @Override
    public String getThumbnailUrl() {
        return imagUrl;
    }


}
