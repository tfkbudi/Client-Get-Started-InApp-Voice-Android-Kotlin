package com.nexmo.client.getstarted.calls;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.nexmo.client.NexmoCall;
import com.nexmo.client.NexmoCallEventListener;
import com.nexmo.client.NexmoCallMember;
import com.nexmo.client.NexmoCallStatus;
import com.nexmo.client.NexmoMediaActionState;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;

public class OnCallActivity extends BaseActivity {

    NexmoCallEventListener callEventListener = new FinishOnCallEnd(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_call);
        NexmoHelper.currentCall.addCallEventListener(callEventListener);
    }

    public void onHangup(View view) {
        NexmoRequestListener<NexmoCall> listener = new NexmoRequestListener<NexmoCall>() {
            @Override
            public void onError(NexmoApiError nexmoApiError) {
                //TODO handle hangup error
            }

            @Override
            public void onSuccess(NexmoCall call) {
                finish();
            }
        };

        NexmoHelper.currentCall.hangup();
        finish();
    }


    @Override
    protected void onDestroy() {
        NexmoHelper.currentCall.removeCallEventListener(callEventListener);
        super.onDestroy();
    }

}
