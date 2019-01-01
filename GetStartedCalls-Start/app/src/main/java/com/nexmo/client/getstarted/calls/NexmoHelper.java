package com.nexmo.client.getstarted.calls;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.nexmo.client.NexmoCall;
import com.nexmo.client.NexmoCallMember;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoConnectionState;
import com.nexmo.client.NexmoIncomingCallListener;
import com.nexmo.client.NexmoUser;
import com.nexmo.client.request_listener.NexmoLoginListener;

class NexmoHelper {

    static final String USER_NAME_JANE = "Jane";
    static final String USER_NAME_JOE = "Joe";
    static final String USER_ID_JANE = "USR-XXX"; //TODO: swap with the UserId you generated for Jane
    static final String USER_ID_JOE = "USR-XXX"; //TODO: swap with the UserId you generated for Jane
    static final String JWT_JANE = "PLACEHOLDER";//TODO: swap with the JWT you generated for Jane
    static final String JWT_JOE = "PLACEHOLDER"; //TODO: swap with the JWT you generated for Joe

    public static NexmoUser user;
    public static NexmoCall currentCall;
    private static Context context;
    private static boolean didInit;


    static NexmoLoginListener loginListener = new NexmoLoginListener() {
        @Override
        public void onLoginStateChange(NexmoLoginListener.ELoginState eLoginState, NexmoLoginListener.ELoginStateReason eLoginStateReason) {
            //TODO
        }

        @Override
        public void onAvailabilityChange(NexmoLoginListener.EAvailability eAvailability, NexmoConnectionState nexmoConnectionState) {
            //TODO
        }
    };

    NexmoIncomingCallListener incomingCallListener = new NexmoIncomingCallListener() {
        @Override
        public void onIncomingCall(NexmoCall call) {
            NexmoHelper.currentCall = call;
            if (context != null) {
                context.startActivity(new Intent(context, OnCallActivity.class));
            }
        }
    };

    public static void init(Context appContext) {
        if (didInit) {
            return;
        }
        didInit = true;
        context = appContext;
        NexmoClient.init(new NexmoClient.NexmoClientConfig(), context, loginListener);
    }

    public static String getUserName() {
        return user.getName();
    }

    public static String getOtherUserName() {
        return user.getName().equals(USER_NAME_JANE) ? USER_NAME_JOE : USER_NAME_JANE;
    }

    public static String getOtherUserId() {
        return user.getName().equals(USER_NAME_JANE) ? USER_ID_JOE : USER_ID_JANE;
    }
}
