package com.wusongyuan.base.module;

import android.app.Application;

import java.util.HashMap;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public class ModuleManager {
    private HashMap<String, Module> mModuleHashMap;
    static ModuleManager INSTANCE = ModuleManagerInstance.module;
    private Application mApplication;

    public static class ModuleManagerInstance {
        final static ModuleManager module = new ModuleManager();
    }

    private ModuleManager() {
        mModuleHashMap = new HashMap<>();
    }

    public static ModuleManager getInstance() {
        return INSTANCE;
    }

    public static Module LoadModule(String moduleName) {
        return getInstance().mModuleHashMap.get(moduleName);
    }

    public static void putModule(String moduleName, Module module) {
        getInstance().mModuleHashMap.put(moduleName, module);
        module.getApplication().initApplication(INSTANCE.mApplication);
    }

    public static void putModule(Proxy proxy) {
        getInstance().mModuleHashMap.put(proxy.getModuleClassName(), proxy.getProxy());
    }

    public static void loadApplication(Application application) {
        INSTANCE.mApplication = application;
        //if (INSTANCE.mModuleHashMap != null && !INSTANCE.mModuleHashMap.isEmpty()) {
        //    for (Map.Entry<String, Module> entry : INSTANCE.mModuleHashMap.entrySet()) {
        //        if (entry != null) {
        //            Module module = entry.getValue();
        //            IApplication iApplication = module.getApplication();
        //            iApplication.initApplication(application);
        //        }
        //    }
        //}
    }
}
