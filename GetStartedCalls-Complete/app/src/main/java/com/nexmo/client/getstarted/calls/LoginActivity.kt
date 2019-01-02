package com.nexmo.client.getstarted.calls

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoUser
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener

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
        NexmoClient.get().login(token, object : NexmoRequestListener<NexmoUser> {

            override fun onError(nexmoApiError: NexmoApiError) {
                notifyError(nexmoApiError)
            }

            override fun onSuccess(user: NexmoUser) {
                NexmoHelper.user = user

                val intent = Intent(baseContext, CreateCallActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}
