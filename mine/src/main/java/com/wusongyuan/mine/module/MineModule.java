package com.wusongyuan.mine.module;

import com.wusongyuan.base.module.IApplication;
import com.wusongyuan.base.module.mine.IMineService;
import com.wusongyuan.base.module.mine.IMineUI;
import com.wusongyuan.base.module.Module;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public class MineModule extends Module<IMineUI, IMineService> {
    @Override
    public IMineUI getUiInterface() {
        return new MineUI();
    }

    @Override
    public IMineService getServiceInterface() {
        return new MineService();
    }

    @Override
    public IApplication getApplication() {
        return new MineAppilication();
    }
}
