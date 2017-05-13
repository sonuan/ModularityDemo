package com.wusongyuan.base.module;

import android.text.TextUtils;
import android.util.Log;

public abstract class Proxy<T, C> implements IProxy<T, C> {
    private static final String TAG = "Proxy";

    private Module<T, C> proxy;

    @Override
    public final T getUiInterface() {
        return getProxy().getUiInterface();
    }

    @Override
    public final C getServiceInterface() {
        return getProxy().getServiceInterface();
    }

    public abstract String getModuleClassName();

    public abstract Module<T, C> getDefaultModule();

    protected Module<T, C> getProxy() {
        if (proxy == null) {
            String module = getModuleClassName();
            if (!TextUtils.isEmpty(module)) {
                try {
                    proxy = (Module<T, C>) ModuleManager.LoadModule(module);
                } catch (Throwable e) {
                    Log.e(TAG, module + " module load failed", e);
                    proxy = getDefaultModule();
                }
            }
        }
        return proxy;
    }
}