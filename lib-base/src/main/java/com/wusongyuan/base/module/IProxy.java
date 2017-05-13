package com.wusongyuan.base.module;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public interface IProxy<T, C> {

    T getUiInterface();

    C getServiceInterface();

}
