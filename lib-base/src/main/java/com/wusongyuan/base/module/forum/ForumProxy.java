package com.wusongyuan.base.module.forum;

import com.wusongyuan.base.module.Module;
import com.wusongyuan.base.module.Proxy;

/**
 * @author wusongyuan
 * @date 2017.05.15
 * @desc
 */

public class ForumProxy extends Proxy {
    public static ForumProxy instance = new ForumProxy();
    @Override
    public String getModuleClassName() {
        return "com.wusongyuan.forum";
    }

    @Override
    public Module getDefaultModule() {
        return null;
    }
}
