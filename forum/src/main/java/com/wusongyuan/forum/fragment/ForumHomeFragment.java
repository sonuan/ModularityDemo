package com.wusongyuan.forum.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wusongyuan.base.constans.AccountUtil;
import com.wusongyuan.base.utils.BasePreferencesUtil;
import com.wusongyuan.forum.R;

import static com.wusongyuan.base.utils.BasePreferencesUtil.MINE_PACKAGE_NAME;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForumHomeFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = "ForumHomeFragment";

    private TextView mInfoTv;
    private Button mDataSpTv;
    private Button mDataUidTv;
    private Button mDataCpTv;
    private Button mDataAidlTv;
    private Button mDataCleanTv;

    public static ForumHomeFragment newInstance() {
        Bundle args = new Bundle();
        ForumHomeFragment fragment = new ForumHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_home_fragment, container, false);
        mInfoTv = (TextView) view.findViewById(R.id.forum_home_info_tv);
        mDataSpTv = (Button) view.findViewById(R.id.forum_home_data_sp_tv);
        mDataUidTv = (Button) view.findViewById(R.id.forum_home_data_uid_tv);
        mDataCpTv = (Button) view.findViewById(R.id.forum_home_data_cp_tv);
        mDataAidlTv = (Button) view.findViewById(R.id.forum_home_data_aidl_tv);
        mDataCleanTv = (Button) view.findViewById(R.id.forum_home_data_clean_tv);

        mDataSpTv.setOnClickListener(this);
        mDataUidTv.setOnClickListener(this);
        mDataCpTv.setOnClickListener(this);
        mDataAidlTv.setOnClickListener(this);
        mDataCleanTv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.forum_home_data_sp_tv) {
            AccountUtil.init();
            if (!AccountUtil.isLogined()) {
                Intent intent = new Intent("com.mine.login");
                startActivity(intent);
                return;
            }
            updateLoginInfo();
            Toast.makeText(getContext(), "user:" + AccountUtil.getUsername() + " password:" + AccountUtil.getPassword(),
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.forum_home_data_uid_tv) {
            try {
                Context context = getContext().createPackageContext(MINE_PACKAGE_NAME, Context.CONTEXT_IGNORE_SECURITY);
                SharedPreferences sharedPreferences = context.getSharedPreferences(
                        BasePreferencesUtil.getDefaultSharedPreferencesName(BasePreferencesUtil.MINE_PACKAGE_NAME), Context.MODE_PRIVATE);
                String username = sharedPreferences.getString(BasePreferencesUtil.MINE_LOGIN_USERNAME, "");
                Toast.makeText(getContext(), "user:" + username, Toast.LENGTH_SHORT).show();
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.forum_home_data_clean_tv) {
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
            mInfoTv.setText("已登录\n用户名:" + AccountUtil.getUsername() + "\n密码:" + AccountUtil.getPassword());
            mDataCleanTv.setEnabled(true);
        } else {
            mDataCleanTv.setEnabled(false);
            mInfoTv.setText("未登录");
        }
    }
}
