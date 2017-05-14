package com.wusongyuan.forum.module;

import com.wusongyuan.base.module.IApplication;
import com.wusongyuan.base.module.Module;

/**
 * @author wusongyuan
 * @date 2017.05.15
 * @desc
 */

public class ForumModule extends Module {
    @Override
    public Object getUiInterface() {
        return null;
    }

    @Override
    public Object getServiceInterface() {
        return null;
    }

    @Override
    public IApplication getApplication() {
        return new ForumApplication();
    }
}
