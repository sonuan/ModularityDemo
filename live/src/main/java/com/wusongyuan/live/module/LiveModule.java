package com.wusongyuan.live.module;

import com.wusongyuan.base.module.IApplication;
import com.wusongyuan.base.module.Module;
import com.wusongyuan.live.debug.LiveApplication;

/**
 * @author wusongyuan
 * @date 2017.05.14
 * @desc
 */

public class LiveModule extends Module {
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
        return new LiveApplication();
    }
}
