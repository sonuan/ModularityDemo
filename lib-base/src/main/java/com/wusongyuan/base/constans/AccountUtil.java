package com.wusongyuan.base.constans;

import android.util.Log;

import com.wusongyuan.base.utils.BasePreferencesUtil;

/**
 * @author wusongyuan
 * @date 2017.04.26
 * @desc
 */

public class AccountUtil {

    private static final String TAG = "AccountUtil";

    private static boolean isLogined = false;
    private static String username = "";
    private static String password = "";

    public static boolean isLogined() {
        return isLogined;
    }

    public static void init() {
        if (BasePreferencesUtil.isLogined()) {
            isLogined = true;
            username = BasePreferencesUtil.getMineLoginUserName();
            password = BasePreferencesUtil.getMineLoginPassword();
        } else {
            isLogined = false;
        }
        Log.i(TAG, "init: username:" + username + " password:" + password);
    }

    public static void login() {
        AccountUtil.isLogined = true;
        BasePreferencesUtil.setLogined(isLogined);
        BasePreferencesUtil.setMineLogin(username, password);
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        AccountUtil.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        AccountUtil.password = password;
    }

    public static void logout() {
        setPassword(null);
        setUsername(null);
        AccountUtil.isLogined = false;
    }
}
