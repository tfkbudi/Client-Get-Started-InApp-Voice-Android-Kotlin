package com.nexmo.client.getstarted.calls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoUser;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        NexmoHelper.init(getApplicationContext());
    }

    public void onLoginJaneClick(View view) {
        loginToSdk(NexmoHelper.JWT_JANE);
    }

    public void onLoginJoeClick(View view) {
        loginToSdk(NexmoHelper.JWT_JOE);
    }

    private void loginToSdk(String token) {
        //TODO: to complete
    }
}
