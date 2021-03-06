package com.somnus.androidphotoviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.somnus.androidphotoviewdemo.glideuils.GlideUtils;
import com.somnus.preview.ImageViewPreviewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageInfo> mlist;
    private ImageView mImageView01, mImageView02, mImageView03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView01 = findViewById(R.id.iv_img01);
        mImageView02 = findViewById(R.id.iv_img02);
        mImageView03 = findViewById(R.id.iv_img03);


        mlist = new ArrayList<>();
        final ImageInfo mInfo = new ImageInfo();
        mInfo.setImagUrl("http://imgsrc.baidu.com/imgad/pic/item/caef76094b36acaf0accebde76d98d1001e99ce7.jpg");
        mlist.add(mInfo);
        GlideUtils.loadImage(this, mInfo.getImagUrl(), mImageView01);


        ImageInfo mInfo1 = new ImageInfo();
        mInfo1.setImagUrl("http://img5.imgtn.bdimg.com/it/u=2449574008,2153104751&fm=26&gp=0.jpg");
        mlist.add(mInfo1);
        GlideUtils.loadImage(this, mInfo1.getImagUrl(), mImageView02);

        ImageInfo mInfo2 = new ImageInfo();
        mInfo2.setImagUrl("http://pic.58pic.com/58pic/13/20/61/89B58PIC5Nz_1024.jpg");
        mlist.add(mInfo2);
        GlideUtils.loadImage(this, mInfo2.getImagUrl(), mImageView03);


        mImageView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageViewPreviewActivity.startView(MainActivity.this, mlist, mImageView01, 0);
            }
        });
        mImageView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewPreviewActivity.startView(MainActivity.this, mlist, mImageView02, 1);

            }
        });
        mImageView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewPreviewActivity.startView(MainActivity.this, mlist, mImageView03, 2);
            }
        });
    }


    @Override
    public void finishAfterTransition() {
        super.finishAfterTransition();
    }
}
