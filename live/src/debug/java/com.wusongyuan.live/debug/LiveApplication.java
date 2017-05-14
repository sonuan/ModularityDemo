package com.wusongyuan.live.debug;

import android.app.Application;

import com.wusongyuan.base.constans.AccountUtil;
import com.wusongyuan.base.module.IApplication;
import com.wusongyuan.base.utils.BasePreferencesUtil;
import com.wusongyuan.live.BuildConfig;

/**
 * @author wusongyuan
 * @date 2017.05.14
 * @desc
 */

public class LiveApplication implements IApplication {
    @Override
    public void initApplication(Application application) {
        BasePreferencesUtil.init(BuildConfig.isSingleModuleDebug);
        AccountUtil.init();
    }
}
