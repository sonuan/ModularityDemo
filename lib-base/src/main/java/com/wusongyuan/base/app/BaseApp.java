package com.wusongyuan.base.app;

import android.support.multidex.MultiDexApplication;

import com.wusongyuan.base.module.ModuleManager;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public class BaseApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ModuleManager.loadApplication(this);
    }
}
