package com.wusongyuan.base.app;

import android.support.multidex.MultiDexApplication;

import com.wusongyuan.base.module.ModuleManager;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public class BaseApp extends MultiDexApplication {

    public static BaseApp INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        ModuleManager.loadApplication(this);
    }
}
