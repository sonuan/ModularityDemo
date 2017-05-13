package com.wusongyuan.mall.debug;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wusongyuan.base.app.BaseActivity;
import com.wusongyuan.mall.R;
import com.wusongyuan.mall.fragment.MallHomeFragment;

public class MallMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.live_home_fl, MallHomeFragment.newInstance(), MallHomeFragment.TAG);
        ft.commitAllowingStateLoss();
    }
}
