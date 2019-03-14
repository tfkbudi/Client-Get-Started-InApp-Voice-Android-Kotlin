package com.nexmo.client.getstarted.calls

import android.os.Bundle
import android.view.View
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
        //TODO: to complete
    }
}
