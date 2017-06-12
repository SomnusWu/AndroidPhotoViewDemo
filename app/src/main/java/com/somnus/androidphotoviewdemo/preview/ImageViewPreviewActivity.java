package com.somnus.androidphotoviewdemo.preview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.somnus.androidphotoviewdemo.ImageInfo;
import com.somnus.androidphotoviewdemo.R;

import java.util.List;

/**
 * Created by Somnus on 2017/6/12.
 *
 * @Description:
 */

public class ImageViewPreviewActivity extends AppCompatActivity {
    public static final String IMAGE_INFO = "images";
    public static final String CURRENT_ITEM = "item";

    private ImageViewAdapetr mImageViewAdapetr;
    private List<ImageInfo> mImageInfos;
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
            mImageInfos = (List<ImageInfo>) getIntent().getSerializableExtra(IMAGE_INFO);
            currentItem = getIntent().getIntExtra(CURRENT_ITEM, 0);
            mTvPage.setText((currentItem + 1) + "/" + mImageInfos.size());
        }
        mImageViewAdapetr = new ImageViewAdapetr(this, mImageInfos);
        mHackyViewPager.setAdapter(mImageViewAdapetr);
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
}
