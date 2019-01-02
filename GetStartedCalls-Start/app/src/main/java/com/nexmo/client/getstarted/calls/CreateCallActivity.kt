package com.nexmo.client.getstarted.calls

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_call.*


class CreateCallActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_call)
        tvTitle.text = String.format("Hi, %s!", NexmoHelper.user?.name)
    }

    fun onInAppCallClick(view: View) {
        //TODO implement
    }

}
