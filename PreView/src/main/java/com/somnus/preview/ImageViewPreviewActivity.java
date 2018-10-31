package com.somnus.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
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


    public static void startView(Context context, ArrayList list, View view, int index) {

        Intent intent = new Intent(context, ImageViewPreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ImageViewPreviewActivity.IMAGE_INFO, list);
        bundle.putInt(ImageViewPreviewActivity.CURRENT_ITEM, index);
        intent.putExtras(bundle);
        startActivityOption(context, intent, view, "img");
    }

    public static void startActivityOption(Context context, Intent mIntent, View view, String shareName) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, view, shareName);
            context.startActivity(mIntent, options.toBundle());
        } else {
            context.startActivity(mIntent);
        }
    }
}
