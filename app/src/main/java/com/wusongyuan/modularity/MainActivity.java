package com.wusongyuan.modularity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.wusongyuan.base.app.BaseActivity;
import com.wusongyuan.forum.fragment.ForumHomeFragment;
import com.wusongyuan.live.fragment.LiveHomeFragment;
import com.wusongyuan.mall.fragment.MallHomeFragment;
import com.wusongyuan.mine.fragment.MineHomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private List<Fragment> mFragments;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        findViewById(R.id.app_main_tab_mall_tv).setOnClickListener(this);
        findViewById(R.id.app_main_tab_live_tv).setOnClickListener(this);
        findViewById(R.id.app_main_tab_forum_tv).setOnClickListener(this);
        findViewById(R.id.app_main_tab_mine_tv).setOnClickListener(this);


        mFragments = new ArrayList<>();
        mFragments.add(MallHomeFragment.newInstance());
        mFragments.add(LiveHomeFragment.newInstance());
        mFragments.add(ForumHomeFragment.newInstance());
        mFragments.add(MineHomeFragment.newInstance());
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return mFragments == null ? null : mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments == null ? 0 : mFragments.size();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_main_tab_mall_tv:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.app_main_tab_live_tv:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.app_main_tab_forum_tv:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.app_main_tab_mine_tv:
                mViewPager.setCurrentItem(3);
                break;
        }
    }
}
