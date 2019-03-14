package com.nexmo.client.getstarted.calls

import android.os.Bundle
import android.view.View
import com.nexmo.client.NexmoCallHandler
import com.nexmo.client.NexmoClient
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUiAccordingToEnabledFeatures()
    }

    fun onInAppCallClick(view: View) {
        //TODO implement
    }

    fun onPhoneCallClick(view: View) {
        //TODO implement
    }



    private fun setUiAccordingToEnabledFeatures() {
        tvTitle.text = "Hi , ${NexmoClient.get().user?.name} !"

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
