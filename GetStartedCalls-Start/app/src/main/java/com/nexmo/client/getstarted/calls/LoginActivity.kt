package com.nexmo.client.getstarted.calls

import android.os.Bundle
import android.view.View

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        NexmoHelper.init(applicationContext)
    }

    fun onLoginJaneClick(view: View) {
        loginToSdk(NexmoHelper.JWT_JANE)
    }

    fun onLoginJoeClick(view: View) {
        loginToSdk(NexmoHelper.JWT_JOE)
    }

    private fun loginToSdk(token: String) {
        //TODO: to complete
    }
}
