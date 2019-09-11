package com.nexmo.client.getstarted.calls

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoUser
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLoginJoe.visibility =
                if (enabledFeatures.contains(Features.IN_APP_to_IN_APP)) {
                    View.VISIBLE
                } else
                    View.GONE
        init(applicationContext)
    }

    fun onLoginJaneClick(view: View) {
        loginToSdk(JWT_JANE)
    }

    fun onLoginJoeClick(view: View) {
        loginToSdk(JWT_JOE)
    }

    private fun loginToSdk(token: String) {
        NexmoClient.get().login(token, object : NexmoRequestListener<NexmoUser> {

            override fun onError(nexmoApiError: NexmoApiError) {
                notifyError(nexmoApiError)
            }

            override fun onSuccess(user: NexmoUser?) {
                currentUser = user

                val intent = Intent(baseContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}
