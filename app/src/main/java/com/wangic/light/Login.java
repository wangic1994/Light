package com.wangic.light;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by wangic on 2018/3/10.
 */
public class Login extends Activity implements View.OnClickListener {
    private EditText user_name;
    private EditText pwd;
    private Button login;

    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    SharedPreferences sharedPreferences = Login.this.getSharedPreferences(Constance.SP, MODE_APPEND);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(Constance.SP_LOGIN_STATUS,true);
                    edit.commit();
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                    Login.this.finish();

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login = (Button) findViewById(R.id.login);
        pwd = (EditText) findViewById(R.id.pwd);
        user_name = (EditText) findViewById(R.id.user_name);
        login.setOnClickListener(this);
        pwd.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String trim = user_name.getText().toString().trim();
                String trim1 = pwd.getText().toString().trim();
                verify(trim, trim1);
                break;
            default:
                break;
        }
    }

    private void verify(String userName, String pwd) {
        RequestParams requestParams = new RequestParams(Constance.longin);
        requestParams.addParameter("username","1");
        requestParams.addParameter("pwd","1");
        x.http().post(requestParams, new Callback.CommonCallback<String >() {
            @Override
            public void onSuccess(String result) {
                Log.e("wangic",result);
                Message m = new Message();
                m.what = 1;
                myHandler.sendMessage(m);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("wangic",ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
