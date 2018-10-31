package com.somnus.preview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;


/**
 * Created by Somnus on 2017/6/12.
 *
 * @Description:
 */

public class ImageViewAdapter<T> extends PagerAdapter implements OnPhotoTapListener {

    private Context mContext;
    private List<T> mData;
    RequestOptions options = new RequestOptions()
            .placeholder(R.drawable.ic_default_error)
            .error(R.drawable.ic_default_error)
            .priority(Priority.HIGH);



    public ImageViewAdapter(Context mContext, List<T> data) {
        this.mContext = mContext;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {

        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_photoview, container, false);


        final PhotoView imageView = (PhotoView) view.findViewById(R.id.pv);
        final ProgressBar mProgressBar = view.findViewById(R.id.pb);
        imageView.setOnPhotoTapListener(this);

        String imageUrl = getContextText(mData.get(position));


        Glide.with(mContext)
                .load(imageUrl)
                .apply(options.bitmapTransform(new BlurTransformation(40)))
                .into(new SimpleTarget<Drawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        view.setBackground(resource);
                    }
                });

        Glide.with(mContext).load(imageUrl).apply(options).into(new DrawableImageViewTarget(imageView) {
            @Override
            public void onStart() {
                super.onStart();
//                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                super.onResourceReady(resource, transition);
//                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onStop() {
                super.onStop();
//                mProgressBar.setVisibility(View.GONE);
            }
        });
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
//        ((ImageViewPreviewActivity) mContext).finishAfterTransition();
//        ((ImageViewPreviewActivity) mContext).overridePendingTransition(0, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ((ImageViewPreviewActivity) mContext).finishAfterTransition();
        } else {
            ((ImageViewPreviewActivity) mContext).finish();
        }

    }

    private String getContextText(T item) {
        if (item == null) {
            return "";
        } else if (item instanceof String) {
            return (String) item;
        } else if (item instanceof IPreviewUrl) {
            return ((IPreviewUrl) item).getThumbnailUrl();
        }
        return item.toString();
    }
}
