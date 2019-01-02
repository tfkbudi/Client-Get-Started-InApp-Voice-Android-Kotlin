package com.nexmo.client.getstarted.calls

import android.content.Context
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConnectionState
import com.nexmo.client.NexmoUser
import com.nexmo.client.request_listener.NexmoLoginListener
import java.lang.ref.WeakReference

internal class NexmoHelper {

    companion object {

        const val USER_NAME_JANE = "Jane"
        const val USER_NAME_JOE = "Joe"
        const val USER_ID_JANE = "USR-XXX" //TODO: swap with the UserId you generated for Jane
        const val USER_ID_JOE = "USR-XXX" //TODO: swap with the UserId you generated for Joe
        const val JWT_JANE = "PLACEHOLDER"//TODO: swap with the JWT you generated for Jane
        const val JWT_JOE = "PLACEHOLDER" //TODO: swap with the JWT you generated for Joe

        var user: NexmoUser? = null
        var currentCall: NexmoCall? = null
        lateinit var contextRef: WeakReference<Context>
        private var didInit: Boolean = false


        var loginListener: NexmoLoginListener = object : NexmoLoginListener {
            override fun onLoginStateChange(eLoginState: NexmoLoginListener.ELoginState, eLoginStateReason: NexmoLoginListener.ELoginStateReason) {
                //TODO
            }

            override fun onAvailabilityChange(eAvailability: NexmoLoginListener.EAvailability, nexmoConnectionState: NexmoConnectionState) {
                //TODO
            }
        }

        fun init(appContext: Context) {
            if (didInit) {
                return
            }
            didInit = true
            contextRef = WeakReference(appContext)
            NexmoClient.init(NexmoClient.NexmoClientConfig(), appContext, loginListener)
        }

        val userName: String
            get() = user!!.name

        val otherUserName: String
            get() = if (user!!.name == USER_NAME_JANE) USER_NAME_JOE else USER_NAME_JANE

        val otherUserId: String
            get() = if (user!!.name == USER_NAME_JANE) USER_ID_JOE else USER_ID_JANE
    }
}
