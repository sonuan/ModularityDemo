package com.wusongyuan.base.constans;

/**
 * @author wusongyuan
 * @date 2017.04.26
 * @desc
 */

public class AccountUtil {

    private static boolean isLogined = false;
    private static String username = "";
    private static String password = "";

    public static boolean isLogined() {
        return isLogined;
    }

    public static void setLogined(boolean isLogined) {
        AccountUtil.isLogined = isLogined;
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
        setLogined(false);
    }
}
