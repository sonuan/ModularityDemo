package com.wusongyuan.mall.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wusongyuan.mall.R;

import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class MallHomeFragment extends Fragment {

    public static final String TAG = "MallHomeFragment";
    private ImageView mIvBg;

    public static MallHomeFragment newInstance() {
        Bundle args = new Bundle();
        MallHomeFragment fragment = new MallHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mall_home_fragment, container, false);
        mIvBg = (ImageView) view.findViewById(R.id.mall_home_iv);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InputStream is = null;
        try {
            is = getResources().getAssets().open("mall_ic.png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            // TODO: 2017/4/24 压缩
            mIvBg.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
