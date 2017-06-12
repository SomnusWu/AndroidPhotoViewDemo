package com.somnus.androidphotoviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.somnus.androidphotoviewdemo.preview.ImageViewPreviewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageInfo> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlist = new ArrayList<>();
        ImageInfo mInfo = new ImageInfo();
        mInfo.setThumbnailUrl("http://imgsrc.baidu.com/imgad/pic/item/caef76094b36acaf0accebde76d98d1001e99ce7.jpg");
        mlist.add(mInfo);


        ImageInfo mInfo1 = new ImageInfo();
        mInfo1.setThumbnailUrl("http://img5.imgtn.bdimg.com/it/u=2449574008,2153104751&fm=26&gp=0.jpg");
        mlist.add(mInfo1);

        ImageInfo mInfo2 = new ImageInfo();
        mInfo2.setThumbnailUrl("http://pic.58pic.com/58pic/13/20/61/89B58PIC5Nz_1024.jpg");
        mlist.add(mInfo2);

    }

    public void onclick(View view) {
        Intent intent = new Intent(this, ImageViewPreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ImageViewPreviewActivity.IMAGE_INFO, mlist);
        bundle.putInt(ImageViewPreviewActivity.CURRENT_ITEM, 0);
        intent.putExtras(bundle);
        this.startActivity(intent);
        this.overridePendingTransition(0, 0);
    }
}
