package com.nexmo.client.getstarted.calls

import android.os.Bundle
import android.view.View
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoCallEventListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener

class OnCallActivity : BaseActivity() {

    internal var callEventListener: NexmoCallEventListener = FinishOnCallEnd(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_call)
    }

    override fun onStart() {
        super.onStart()
        currentCall?.addCallEventListener(callEventListener)
    }

    fun onHangup(view: View) {
        currentCall?.hangup(object : NexmoRequestListener<NexmoCall> {
            override fun onSuccess(call: NexmoCall?) {
                finish()
                currentCall = null
            }

            override fun onError(nexmoApiError: NexmoApiError) {
                notifyError(nexmoApiError)
            }

        })
    }


    override fun onStop() {
        currentCall?.removeCallEventListener(callEventListener)
        super.onStop()
    }

}
