package com.somnus.androidphotoviewdemo.preview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.somnus.androidphotoviewdemo.GlideUtils;
import com.somnus.androidphotoviewdemo.ImageInfo;
import com.somnus.androidphotoviewdemo.R;

import java.util.List;

/**
 * Created by Somnus on 2017/6/12.
 *
 * @Description:
 */

public class ImageViewAdapetr extends PagerAdapter implements OnPhotoTapListener {

    private Context mContext;
    private List<ImageInfo> mData;

    public ImageViewAdapetr(Context mContext, List<ImageInfo> data) {
        this.mContext = mContext;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_photoview, container, false);
        final PhotoView imageView = (PhotoView) view.findViewById(R.id.pv);
        imageView.setOnPhotoTapListener(this);
        GlideUtils.loadImage(mContext, mData.get(position).getThumbnailUrl(), imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void onPhotoTap(ImageView view, float x, float y) {
        ((ImageViewPreviewActivity) mContext).finish();
        ((ImageViewPreviewActivity) mContext).overridePendingTransition(0,0);
    }
}
