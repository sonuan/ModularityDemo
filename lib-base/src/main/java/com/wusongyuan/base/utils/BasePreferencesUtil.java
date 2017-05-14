package com.wusongyuan.base.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import com.wusongyuan.base.app.BaseApp;

/**
 * @author wusongyuan
 * @date 2017.05.14
 * @desc
 */

public class BasePreferencesUtil {

    private static boolean isSingleModuleDebug = false;

    public static String MINE_PACKAGE_NAME = null;
    public static String LIVE_PACKAGE_NAME = null;
    public static String MALL_PACKAGE_NAME = null;
    public static String FORUM_PACKAGE_NAME = null;

    public static void init(boolean debug){
        isSingleModuleDebug = debug;
        if (isSingleModuleDebug) {
            MINE_PACKAGE_NAME = "com.wusongyuan.mine.debug";
            LIVE_PACKAGE_NAME = "com.wusongyuan.live.debug";
            MALL_PACKAGE_NAME = "com.wusongyuan.mall.debug";
            FORUM_PACKAGE_NAME = "com.wusongyuan.forum.debug";
        } else {
            MINE_PACKAGE_NAME = "com.wusongyuan.mine";
            LIVE_PACKAGE_NAME = "com.wusongyuan.live";
            MALL_PACKAGE_NAME = "com.wusongyuan.mall";
            FORUM_PACKAGE_NAME = "com.wusongyuan.forum";
        }
    }
    public static SharedPreferences geDefaultSharedPreferences() {
        return BaseApp.INSTANCE.getSharedPreferences(getDefaultSharedPreferencesName(BaseApp.INSTANCE),
                getDefaultSharedPreferencesMode());
    }

    public static String getDefaultSharedPreferencesName(Context comtext) {
        return comtext.getPackageName() + "_preferences";
    }

    public static String getDefaultSharedPreferencesName(String packageName) {
        return packageName + "_preferences";
    }

    private static int getDefaultSharedPreferencesMode() {
        return isSingleModuleDebug ? Context.MODE_MULTI_PROCESS | Context.MODE_WORLD_READABLE : Context.MODE_PRIVATE;
        //return Context.MODE_PRIVATE;
    }


    public static SharedPreferences getMineSharedPreferences(){
        Context comtext;
        if (isSingleModuleDebug) {
            try {
                comtext = BaseApp.INSTANCE.createPackageContext(MINE_PACKAGE_NAME, Context.CONTEXT_IGNORE_SECURITY);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                comtext = BaseApp.INSTANCE;
            }
        } else {
            comtext = BaseApp.INSTANCE;
        }
        return comtext.getSharedPreferences(getDefaultSharedPreferencesName(MINE_PACKAGE_NAME),
                getDefaultSharedPreferencesMode());
    }

    ///////////////////////////////////////////////
    ///////////////////////////////////////////////
    //登录相关数据//////////////////////////////////
    ///////////////////////////////////////////////

    public static final String MINE_LOGIN_USERNAME = "MINE_LOGIN_USERNAME";
    public static final String MINE_LOGIN_PASSWORD = "MINE_LOGIN_PASSWORD";
    public static final String MINE_LOGIN_ISLOGIN = "MINE_LOGIN_ISLOGIN";
    public static void setMineLogin(String username, String password) {
        SharedPreferences sharedPreferences = getMineSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MINE_LOGIN_USERNAME, username);
        editor.putString(MINE_LOGIN_PASSWORD, password);
        editor.apply();
    }

    public static String getMineLoginUserName() {
        return getMineSharedPreferences().getString(MINE_LOGIN_USERNAME, "");
    }

    public static String getMineLoginPassword() {
        return getMineSharedPreferences().getString(MINE_LOGIN_PASSWORD, "");
    }

    public static void setLogined(boolean isLogined) {
        SharedPreferences sharedPreferences = getMineSharedPreferences();
        sharedPreferences.edit().putBoolean(MINE_LOGIN_ISLOGIN, isLogined).apply();
    }

    public static boolean isLogined() {
        return getMineSharedPreferences().getBoolean(MINE_LOGIN_ISLOGIN, false);
    }
}
