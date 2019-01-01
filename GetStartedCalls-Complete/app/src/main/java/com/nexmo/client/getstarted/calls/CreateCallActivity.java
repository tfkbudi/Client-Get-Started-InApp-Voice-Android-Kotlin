package com.nexmo.client.getstarted.calls;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nexmo.client.NexmoCall;
import com.nexmo.client.NexmoCallHandler;
import com.nexmo.client.NexmoCallMember;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoIncomingCallListener;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;

import java.util.ArrayList;
import java.util.List;

public class CreateCallActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_call);
        TextView title = findViewById(R.id.tvTitle);
        title.setText(String.format("Hi, %s!", NexmoHelper.getUserName()));

    }

    public void onInAppCallClick(View view) {
        //TODO implement
    }

    public void onCallPhoneClick(View view) {
        //TODO implement
    }

}
