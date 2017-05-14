package com.wusongyuan.forum.debug;

import com.wusongyuan.base.app.BaseApp;
import com.wusongyuan.base.module.ModuleManager;
import com.wusongyuan.base.module.forum.ForumProxy;
import com.wusongyuan.forum.module.ForumModule;

/**
 * @author wusongyuan
 * @date 2017.05.15
 * @desc
 */

public class ForumApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        ModuleManager.putModule(ForumProxy.instance.getModuleClassName(), new ForumModule());
    }
}
