package com.wusongyuan.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wusongyuan.base.constans.AccountUtil;

public class MineLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsernameEdit;
    private EditText mPasswordEdit;
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, MineLoginActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_login_activity);
        findViewById(R.id.mine_login_login_btn).setOnClickListener(this);
        mUsernameEdit = (EditText) findViewById(R.id.mine_login_username_edit);
        mPasswordEdit = (EditText) findViewById(R.id.mine_login_password_edit);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.mine_login_login_btn) {
            String username = mUsernameEdit.getText().toString();
            String password = mPasswordEdit.getText().toString();
            if (TextUtils.isEmpty(username)) {
                Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            AccountUtil.setLogined(true);
            AccountUtil.setUsername(username);
            AccountUtil.setPassword(password);
            finish();
        }

    }
}
