package com.wusongyuan.base.module.mine;

import com.wusongyuan.base.module.Module;
import com.wusongyuan.base.module.Proxy;

public class MineProxy extends Proxy<IMineUI, IMineService> {
    public static final MineProxy g = new MineProxy();

    // 在没有获得真实实现时候的默认实现
    @Override
    public Module<IMineUI, IMineService> getDefaultModule() {
      return null;
    }

    // 真实实现的类
    @Override
    public String getModuleClassName() {
        return "com.wusongyuan.mine";
    }
}