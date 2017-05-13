package com.wusongyuan.live.debug;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wusongyuan.base.app.BaseActivity;
import com.wusongyuan.live.R;
import com.wusongyuan.live.fragment.LiveHomeFragment;

public class LiveMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.live_home_fl, LiveHomeFragment.newInstance(), LiveHomeFragment.TAG);
        ft.commitAllowingStateLoss();
    }
}
