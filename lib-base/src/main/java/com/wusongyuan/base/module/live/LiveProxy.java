package com.wusongyuan.base.module.live;

import com.wusongyuan.base.module.Module;
import com.wusongyuan.base.module.Proxy;

/**
 * @author wusongyuan
 * @date 2017.05.14
 * @desc
 */

public class LiveProxy extends Proxy {
    public static LiveProxy instance = new LiveProxy();
    @Override
    public String getModuleClassName() {
        return "com.wusongyuan.live";
    }

    @Override
    public Module getDefaultModule() {
        return null;
    }
}
