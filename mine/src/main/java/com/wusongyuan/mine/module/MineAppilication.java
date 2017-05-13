package com.wusongyuan.mine.module;

import android.app.Application;
import android.util.Log;

import com.wusongyuan.base.module.IApplication;

/**
 * @author wusongyuan
 * @date 2017.05.03
 * @desc
 */

public class MineAppilication implements IApplication {
    private static final String TAG = "FeedAppilication";


    @Override
    public void initApplication(Application application) {
        Log.i(TAG, "initApplication: ");
    }
}
