package com.example.yang.recyclerviewpager;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private Context context;
    private ViewPager vp_main;
    private int[] images;
    private ImageView iv_img;
    private ArrayList<ImageView> ivList = new ArrayList<>();
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        vp_main.setOnPageChangeListener(this);
        initImage();
        adapter = new MyPagerAdapter();
        vp_main.setAdapter(adapter);
        vp_main.setCurrentItem(1);
    }

    private void initImage(){
        images = new int[]{
                R.mipmap.pic_5,
                R.mipmap.pic_2,
                R.mipmap.pic_3,
                R.mipmap.pic_4,
                R.mipmap.pic_5,
                R.mipmap.pic_2
        };
        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        for(int i = 0;i < images.length;i++){
            iv_img = new ImageView(context);
            iv_img.setLayoutParams(params);
            iv_img.setImageResource(images[i]);
            ivList.add(iv_img);
        }
    }

    public class MyPagerAdapter extends PagerAdapter{

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(ivList.get(position));
            return ivList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(ivList.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return ivList.size();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(ivList.size() > 1){
            if(position < 1){
                position = ivList.size()-2;
                vp_main.setCurrentItem(position,false);
            } else if(position > ivList.size() -2){
                position = 1;
                vp_main.setCurrentItem(position,false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
