package com.wusongyuan.live.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wusongyuan.base.app.BaseFragment;
import com.wusongyuan.base.constans.AccountUtil;
import com.wusongyuan.base.module.mine.MineProxy;
import com.wusongyuan.live.R;

import java.util.List;


public class LiveHomeFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "LiveHomeFragment";
    private TextView mInfoTv;
    private Button mLoginInterfaceTv;
    private Button mLoginFilterTv;
    private Button mLoginNameTv;
    private Button mLoginSchemeTv;
    private Button mLogoutTv;
    private int mLoginType;

    public static LiveHomeFragment newInstance() {
        Bundle args = new Bundle();
        LiveHomeFragment fragment = new LiveHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.live_home_fragment, container, false);
        mInfoTv = (TextView) view.findViewById(R.id.live_home_info_tv);
        mLoginInterfaceTv = (Button) view.findViewById(R.id.live_home_login_interface_tv);
        mLoginFilterTv = (Button) view.findViewById(R.id.live_home_login_filter_tv);
        mLoginNameTv = (Button) view.findViewById(R.id.live_home_login_class_name_tv);
        mLoginSchemeTv = (Button) view.findViewById(R.id.live_home_login_scheme_tv);
        mLogoutTv = (Button) view.findViewById(R.id.live_home_logout_tv);
        mLoginInterfaceTv.setOnClickListener(this);
        mLoginFilterTv.setOnClickListener(this);
        mLoginNameTv.setOnClickListener(this);
        mLoginSchemeTv.setOnClickListener(this);
        mLogoutTv.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.live_home_login_interface_tv) {
            if (!AccountUtil.isLogined()) {
                mLoginType = i;
                MineProxy.g.getUiInterface().toMineLoginActivity(getActivity());
                return;
            }
            Toast.makeText(getContext(), "user:" + AccountUtil.getUsername() + " password:" + AccountUtil.getPassword(),
                    Toast.LENGTH_SHORT).show();
        } else if (i == R.id.live_home_login_filter_tv) {
            if (!AccountUtil.isLogined()) {
                mLoginType = i;
                Intent intent = new Intent("com.mine.login");
                startActivity(intent);
                return;
            }
            // to do something
        } else if (i == R.id.live_home_login_class_name_tv) {
            if (!AccountUtil.isLogined()) {
                mLoginType = i;
                Intent intent = new Intent();
                intent.setClassName("com.wusongyuan.mine.debug", "com.wusongyuan.mine.MineLoginActivity");
                startActivity(intent);


                //Intent intent2 = new Intent();
                //intent2.setComponent(new ComponentName("com.wusongyuan.mine.debug", "com.wusongyuan.mine.MineLoginActivity"));
                //startActivity(intent2);
                return;
            }
            // to do something
        } else if (i == R.id.live_home_login_scheme_tv) {
            if (!AccountUtil.isLogined()) {
                mLoginType = i;
                String url = "app://mine/login";
                Intent intent = new Intent();
                intent.setData(Uri.parse(url));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                PackageManager packageManager = getActivity().getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
                if (!activities.isEmpty()) {
                    startActivity(intent);
                }
                return;
            }
            // to do something
        } else if (i == R.id.live_home_logout_tv) {
            mLoginType = 0;
            AccountUtil.logout();
            updateLoginInfo();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateLoginInfo();
    }

    private void updateLoginInfo() {
        if (AccountUtil.isLogined()) {
            String loginType = "";
            if (mLoginType == R.id.live_home_login_interface_tv) {
                loginType = "interface";
            } else if (mLoginType == R.id.live_home_login_filter_tv) {
                loginType = "隐式启动";
            } else if (mLoginType == R.id.live_home_login_class_name_tv) {
                loginType = "包名和类名";
            } else if (mLoginType == R.id.live_home_login_scheme_tv) {
                loginType = "scheme跳转";
            }
            mInfoTv.setText("已登录\n登录方式:" + loginType + "\n用户名:" + AccountUtil.getUsername() + "\n密码:"
                    + AccountUtil.getPassword());
            mLogoutTv.setEnabled(true);
        } else {
            mLogoutTv.setEnabled(false);
            mInfoTv.setText("未登录");
        }
    }
}
