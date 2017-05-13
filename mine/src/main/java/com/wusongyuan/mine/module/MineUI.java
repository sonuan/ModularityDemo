package com.wusongyuan.mine.module;

import android.content.Context;

import com.wusongyuan.base.module.mine.IMineUI;
import com.wusongyuan.mine.MineLoginActivity;

/**
 * @author wusongyuan
 * @date 2017.04.25
 * @desc
 */

public class MineUI implements IMineUI {
    @Override
    public void toMineLoginActivity(Context context) {
        if (context != null) {
            MineLoginActivity.toActivity(context);
        }
    }
}
