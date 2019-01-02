package com.nexmo.client.getstarted.calls

import android.os.Bundle
import android.view.View
import com.nexmo.client.NexmoCallEventListener

class OnCallActivity : BaseActivity() {

    internal var callEventListener: NexmoCallEventListener = FinishOnCallEnd(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_call)
    }

    override fun onStart() {
        super.onStart()
        NexmoHelper.currentCall?.addCallEventListener(callEventListener)
    }

    fun onHangup(view: View) {
        NexmoHelper.currentCall!!.hangup()
        finish()
    }


    override fun onStop() {
        NexmoHelper.currentCall?.removeCallEventListener(callEventListener)
        super.onStop()
    }

}
