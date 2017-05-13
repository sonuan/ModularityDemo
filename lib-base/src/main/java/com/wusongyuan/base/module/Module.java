package com.wusongyuan.base.module;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public abstract class Module<T, V>{

    public abstract T getUiInterface();

    public abstract V getServiceInterface();

    public abstract IApplication getApplication();

}
