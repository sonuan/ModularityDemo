package com.wusongyuan.mine;

import com.wusongyuan.base.app.BaseApp;
import com.wusongyuan.base.module.mine.MineProxy;
import com.wusongyuan.base.module.ModuleManager;
import com.wusongyuan.mine.module.MineModule;

/**
 * @author wusongyuan
 * @date 2017.05.03
 * @desc
 */

public class MineApplication extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        ModuleManager.putModule(MineProxy.g.getModuleClassName(), new MineModule());
    }
}
