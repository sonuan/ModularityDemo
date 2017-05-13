package com.wusongyuan.modularity.app;

import com.wusongyuan.base.app.BaseApp;
import com.wusongyuan.base.module.mine.MineProxy;
import com.wusongyuan.base.module.ModuleManager;
import com.wusongyuan.mine.module.MineModule;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public class SubApplication extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        ModuleManager.putModule(MineProxy.g.getModuleClassName(), new MineModule());
    }
}
