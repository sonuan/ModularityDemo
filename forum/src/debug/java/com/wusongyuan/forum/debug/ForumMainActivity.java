package com.wusongyuan.forum.debug;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wusongyuan.base.app.BaseActivity;
import com.wusongyuan.forum.fragment.ForumHomeFragment;
import com.wusongyuan.forum.R;

public class ForumMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.live_home_fl, ForumHomeFragment.newInstance(), ForumHomeFragment.TAG);
        ft.commitAllowingStateLoss();
    }
}
