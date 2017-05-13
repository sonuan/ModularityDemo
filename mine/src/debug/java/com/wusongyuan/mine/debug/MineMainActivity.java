package com.wusongyuan.mine.debug;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wusongyuan.base.app.BaseActivity;
import com.wusongyuan.mine.R;
import com.wusongyuan.mine.fragment.MineHomeFragment;

public class MineMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.live_home_fl, MineHomeFragment.newInstance(), MineHomeFragment.TAG);
        ft.commitAllowingStateLoss();
    }
}
