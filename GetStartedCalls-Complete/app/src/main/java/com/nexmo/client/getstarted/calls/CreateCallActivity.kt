package com.nexmo.client.getstarted.calls

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoCallHandler
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoIncomingCallListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import kotlinx.android.synthetic.main.activity_create_call.*


class CreateCallActivity : BaseActivity() {


    private val incomingCallListener = NexmoIncomingCallListener { call ->
        NexmoHelper.currentCall = call
        startActivity(Intent(this@CreateCallActivity, IncomingCallActivity::class.java))
    }

    internal var callListener: NexmoRequestListener<NexmoCall> = object : NexmoRequestListener<NexmoCall> {
        override fun onError(nexmoApiError: NexmoApiError) {
            notifyError(nexmoApiError)
        }

        override fun onSuccess(call: NexmoCall) {
            NexmoHelper.currentCall = call

            val intent = Intent(this@CreateCallActivity, OnCallActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_call)
        tvTitle.text = String.format("Hi, %s!", NexmoHelper.user?.name)
    }

    override fun onStart() {
        super.onStart()
        NexmoClient.get().addIncomingCallListener(incomingCallListener)
    }

    fun onInAppCallClick(view: View) {
        val callee = listOf(NexmoHelper.otherUserName)
        NexmoClient.get().call(callee, NexmoCallHandler.IN_APP, callListener)
    }

    override fun onStop() {
        NexmoClient.get().removeIncomingCallListeners()
        super.onStop()
    }

}
