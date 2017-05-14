package com.wusongyuan.forum.module;

import android.app.Application;

import com.wusongyuan.base.module.IApplication;

/**
 * @author wusongyuan
 * @date 2017.05.15
 * @desc
 */

public class ForumApplication implements IApplication {
    @Override
    public void initApplication(Application application) {
        //BasePreferencesUtil.init(com.wusongyuan.base.BuildConfig.isSingleModuleDebug);
        //AccountUtil.init();
    }
}
