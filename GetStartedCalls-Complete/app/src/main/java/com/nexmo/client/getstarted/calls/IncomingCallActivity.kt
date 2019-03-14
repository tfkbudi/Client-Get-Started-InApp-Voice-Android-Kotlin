package com.nexmo.client.getstarted.calls

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoCallEventListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener

class IncomingCallActivity : BaseActivity() {

    var callEventListener: NexmoCallEventListener = FinishOnCallEnd(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incoming_call)

        currentCall?.addCallEventListener(callEventListener)
    }

    fun onAnswer(view: View) {
        currentCall?.answer(object : NexmoRequestListener<NexmoCall> {
            override fun onError(nexmoApiError: NexmoApiError) {
                notifyError(nexmoApiError)
            }

            override fun onSuccess(call: NexmoCall) {
                startActivity(Intent(this@IncomingCallActivity, OnCallActivity::class.java))
                finish()
            }
        })
    }

    fun onHangup(view: View) {
        currentCall?.hangup(object : NexmoRequestListener<NexmoCall> {
            override fun onError(nexmoApiError: NexmoApiError) {
                notifyError(nexmoApiError)
            }

            override fun onSuccess(call: NexmoCall) {
                startActivity(Intent(this@IncomingCallActivity, OnCallActivity::class.java))
                finish()
            }
        })
        finish()
    }

    override fun onDestroy() {
        currentCall?.removeCallEventListener(callEventListener)
        super.onDestroy()
    }
}
