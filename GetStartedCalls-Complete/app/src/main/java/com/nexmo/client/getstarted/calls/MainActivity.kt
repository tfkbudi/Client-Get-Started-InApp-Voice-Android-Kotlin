package com.nexmo.client.getstarted.calls

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View

import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoCallHandler
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoIncomingCallListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    val incomingCallListener = NexmoIncomingCallListener { call ->
        Log.d(TAG, "NexmoIncomingCallListener.onIncomingCall()")
        currentCall = call
        startActivity(Intent(this@MainActivity, IncomingCallActivity::class.java))
    }

    var callListener: NexmoRequestListener<NexmoCall> = object : NexmoRequestListener<NexmoCall> {
        override fun onError(nexmoApiError: NexmoApiError) {
            notifyError(nexmoApiError)
        }

        override fun onSuccess(call: NexmoCall?) {
            currentCall = call

            val intent = Intent(this@MainActivity, OnCallActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUiAccordingToEnabledFeatures()
    }


    override fun onStart() {
        super.onStart()
        NexmoClient.get().addIncomingCallListener(incomingCallListener)
    }

    fun onInAppCallClick(view: View) {
        otherUserName?.let { NexmoClient.get().call(it, NexmoCallHandler.IN_APP, callListener) }
    }

    fun onPhoneCallClick(view: View) {
        val callee = PLACEHOLDER //TODO: swap with your phone number
        NexmoClient.get().call(callee, NexmoCallHandler.SERVER, callListener)
    }

    override fun onStop() {
        NexmoClient.get().removeIncomingCallListeners()
        super.onStop()
    }


    private fun setUiAccordingToEnabledFeatures() {
        tvTitle.text = "Hi , ${currentUser?.name} !"

        if (enabledFeatures.contains(Features.IN_APP_to_IN_APP)) {
            tvOr1.visibility = View.VISIBLE
            btnCallUser.visibility = View.VISIBLE
            btnCallUser.text = "In-App call to user $otherUserName"
        } else {
            tvOr1.visibility = View.GONE
            btnCallUser.visibility = View.GONE
        }

        if (enabledFeatures.contains(Features.IN_APP_to_PHONE)) {
            tvOr2.visibility = View.VISIBLE
            btnCallPhone.visibility = View.VISIBLE
        } else {
            tvOr2.visibility = View.GONE
            btnCallPhone.visibility = View.GONE
        }
    }
}
