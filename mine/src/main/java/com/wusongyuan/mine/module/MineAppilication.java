package com.wusongyuan.mine.module;

import android.app.Application;
import android.util.Log;

import com.wusongyuan.base.constans.AccountUtil;
import com.wusongyuan.base.module.IApplication;
import com.wusongyuan.base.utils.BasePreferencesUtil;

/**
 * @author wusongyuan
 * @date 2017.05.03
 * @desc
 */

public class MineAppilication implements IApplication {
    private static final String TAG = "MineAppilication";


    @Override
    public void initApplication(Application application) {
        Log.i(TAG, "initApplication: ");
        BasePreferencesUtil.init(com.wusongyuan.base.BuildConfig.isSingleModuleDebug);
        AccountUtil.init();
    }
}
