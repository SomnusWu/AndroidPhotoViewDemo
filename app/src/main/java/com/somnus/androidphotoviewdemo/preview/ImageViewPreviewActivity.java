package com.somnus.androidphotoviewdemo.preview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.somnus.androidphotoviewdemo.R;

import java.util.List;

/**
 * Created by Somnus on 2017/6/12.
 *
 * @Description:
 */

public class ImageViewPreviewActivity<T> extends AppCompatActivity {
    public static final String IMAGE_INFO = "images";
    public static final String CURRENT_ITEM = "item";

    private ImageViewAdapter mImageViewAdapter;
    private List<T> mImageInfos;
    private int currentItem;
    private HackyViewPager mHackyViewPager;
    private TextView mTvPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        mHackyViewPager = (HackyViewPager) findViewById(R.id.viewPager);
        mTvPage = (TextView) findViewById(R.id.tv_pager);

        if (getIntent() != null) {
            mImageInfos = (List<T>) getIntent().getSerializableExtra(IMAGE_INFO);
            currentItem = getIntent().getIntExtra(CURRENT_ITEM, 0);
            mTvPage.setText((currentItem + 1) + "/" + mImageInfos.size());
        }
        mImageViewAdapter = new ImageViewAdapter(this, mImageInfos);
        mHackyViewPager.setAdapter(mImageViewAdapter);
        mHackyViewPager.setOffscreenPageLimit(mImageInfos.size());
        mHackyViewPager.setCurrentItem(currentItem);

        mHackyViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTvPage.setText((position + 1) + "/" + mImageInfos.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void finishAfterTransition() {
        super.finishAfterTransition();
    }
}
