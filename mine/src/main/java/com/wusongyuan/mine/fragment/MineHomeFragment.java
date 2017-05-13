package com.wusongyuan.mine.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wusongyuan.mine.MineLoginActivity;
import com.wusongyuan.mine.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineHomeFragment extends Fragment implements View.OnClickListener {


    public static final String TAG = "MineHomeFragment";


    public static MineHomeFragment newInstance() {
        Bundle args = new Bundle();
        MineHomeFragment fragment = new MineHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_home_fragment, container, false);
        view.findViewById(R.id.mine_login_tv).setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mine_login_tv) {
            MineLoginActivity.toActivity(getContext());
        } else {

        }
    }
}
