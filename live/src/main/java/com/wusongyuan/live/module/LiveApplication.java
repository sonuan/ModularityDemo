package com.wusongyuan.live.module;

import android.app.Application;

import com.wusongyuan.base.constans.AccountUtil;
import com.wusongyuan.base.module.IApplication;
import com.wusongyuan.base.utils.BasePreferencesUtil;

/**
 * @author wusongyuan
 * @date 2017.05.14
 * @desc
 */

public class LiveApplication implements IApplication {
    @Override
    public void initApplication(Application application) {
        BasePreferencesUtil.init(com.wusongyuan.base.BuildConfig.isSingleModuleDebug);
        AccountUtil.init();
    }
}
