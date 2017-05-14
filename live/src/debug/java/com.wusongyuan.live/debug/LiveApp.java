package com.wusongyuan.live.debug;

import com.wusongyuan.base.app.BaseApp;
import com.wusongyuan.base.module.ModuleManager;
import com.wusongyuan.base.module.live.LiveProxy;
import com.wusongyuan.live.module.LiveModule;

/**
 * @author wusongyuan
 * @date 2017.05.14
 * @desc
 */

public class LiveApp extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleManager.putModule(LiveProxy.instance.getModuleClassName(), new LiveModule());
    }
}
