package com.nexmo.client.getstarted.calls

import android.content.Context
import android.util.Log
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoClient
import java.lang.ref.WeakReference


const val PLACEHOLDER = "PLACEHOLDER"
const val TAG = "Nexmo-get-started"

val enabledFeatures = arrayOf(Features.IN_APP_to_IN_APP, Features.PHONE_to_IN_APP, Features.IN_APP_to_PHONE)

enum class Features { IN_APP_to_IN_APP, PHONE_to_IN_APP, IN_APP_to_PHONE }

const val USER_NAME_JANE = "Jane"
const val USER_NAME_JOE = "Joe"
const val USER_ID_JANE = "USR-XXX" //TODO: swap with the UserId you generated for Jane
const val USER_ID_JOE = "USR-XXX" //TODO: swap with the UserId you generated for Joe
const val JWT_JANE = PLACEHOLDER //TODO: swap with the JWT you generated for Jane
const val JWT_JOE = PLACEHOLDER //TODO: swap with the JWT you generated for Joe

var currentCall: NexmoCall? = null
private var didInit: Boolean = false


fun init(appContext: Context) {
    if (didInit) {
        return
    }
    didInit = true
    NexmoClient.Builder()
            .build(appContext)
            .setConnectionListener { status, reason -> Log.d(TAG, "NexmoConnectionListener.ConnectionStatus : $status : $reason") }
}

val userName: String
    get() = NexmoClient.get().user.name

val otherUserName: String
    get() = if (NexmoClient.get().user.name == USER_NAME_JANE) USER_NAME_JOE else USER_NAME_JANE

val otherUserId: String
    get() = if (NexmoClient.get().user.name == USER_NAME_JANE) USER_ID_JOE else USER_ID_JANE
