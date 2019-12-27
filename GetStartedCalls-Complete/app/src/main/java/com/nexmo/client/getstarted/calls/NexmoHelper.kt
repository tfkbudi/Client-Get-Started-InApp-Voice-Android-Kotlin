package com.nexmo.client.getstarted.calls

import android.content.Context
import android.util.Log
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoUser
import java.lang.ref.WeakReference

const val PLACEHOLDER = "PLACEHOLDER"
const val TAG = "Nexmo-get-started"

val enabledFeatures = arrayOf(Features.IN_APP_to_IN_APP, Features.PHONE_to_IN_APP, Features.IN_APP_to_PHONE)

enum class Features { IN_APP_to_IN_APP, PHONE_to_IN_APP, IN_APP_to_PHONE }

const val USER_NAME_JANE = "goldman"
const val USER_NAME_JOE = "redman"
const val USER_ID_JANE = "goldman" //TODO: swap with the UserId you generated for Jane
const val USER_ID_JOE = "redman" //TODO: swap with the UserId you generated for Joe
const val JWT_JANE = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1Nzc0NTc1NDMsImp0aSI6ImEwOTVjNDMwLTI4YjYtMTFlYS1iYWIyLTdkZWUxMjU5MTIyYyIsImFwcGxpY2F0aW9uX2lkIjoiNmU1MDE0ZjYtYWFlMS00M2E2LThiNDEtZTcwZWIxYTZhNmY0Iiwic3ViIjoiZ29sZG1hbiIsImV4cCI6MTU3NzU0Mzk0MywiYWNsIjp7InBhdGhzIjp7Ii8qL3VzZXJzLyoqIjp7fSwiLyovY29udmVyc2F0aW9ucy8qKiI6e30sIi8qL3Nlc3Npb25zLyoqIjp7fSwiLyovZGV2aWNlcy8qKiI6e30sIi8qL2ltYWdlLyoqIjp7fSwiLyovbWVkaWEvKioiOnt9LCIvKi9hcHBsaWNhdGlvbnMvKioiOnt9LCIvKi9wdXNoLyoqIjp7fSwiLyova25vY2tpbmcvKioiOnt9fX19.O5uReY2wZ3RGwura15L5KMWR7oH8QwIrFoDiz_guwzw-A2TpMJBRLP2HINbqPvSPF4Lc738IC7JrHEEzU34i5WUiCYdZydlcH8J2krtu9vAjppjZO5OMGm20LrFjplX9d_biL3FsDPBKDK8Qfc4qS5Th-PbILVI5zU2WcxWPco9QkoydVvoxIFlvWm9BNbBK7zMoxVz5DDHG5r-RYz2nApRNhmXxktpOCsITagyJ8tE9mlG73UkxQFMY_IZf7S_830UC5VIRZRng5kMF02sALr6EWPAtMT5vA7vopJyBXcFJ9_LEZHoEvB9vUogCxRmxlYJ0kVDfMkdBSVEJaCOBzg" //TODO: swap with the JWT you generated for Jane
const val JWT_JOE = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1Nzc0NTc1ODEsImp0aSI6ImI3OTcwYzcwLTI4YjYtMTFlYS1iYWIyLTdkZWUxMjU5MTIyYyIsImFwcGxpY2F0aW9uX2lkIjoiNmU1MDE0ZjYtYWFlMS00M2E2LThiNDEtZTcwZWIxYTZhNmY0Iiwic3ViIjoicmVkbWFuIiwiZXhwIjoxNTc3NTQzOTgyLCJhY2wiOnsicGF0aHMiOnsiLyovdXNlcnMvKioiOnt9LCIvKi9jb252ZXJzYXRpb25zLyoqIjp7fSwiLyovc2Vzc2lvbnMvKioiOnt9LCIvKi9kZXZpY2VzLyoqIjp7fSwiLyovaW1hZ2UvKioiOnt9LCIvKi9tZWRpYS8qKiI6e30sIi8qL2FwcGxpY2F0aW9ucy8qKiI6e30sIi8qL3B1c2gvKioiOnt9LCIvKi9rbm9ja2luZy8qKiI6e319fX0.qYRJgJjrQY-baKO7e1SBe5_yLCTEZml-Jf3-XJzs95T1rr_tk5aI2YaCLkqDVZ5QhJG7r9kVqZT73jkaG-ivASKfloKkMsreAic_T6kBoOdvrZzljXmbG7g0stdQyBFnASRbFUr9KURt3CL6YFrpHrONDpJhpMIg7Rz3FEgz6C1a9-rWFAShC1j-UyQ-Rgl5kMAQ0GTVWFv00KyXHvI5IZoNWJjC5Hnq-Vtj4JV-x2WnNQNwAVFXtmOTqEMXOCj4MrEBoMCdU6iarjfBxtHnUvDppodYYS6WBYEk26_XekVaCom3voPkhA-0H3VGIsUj8LlkkbbyvL99_1EIp_JO4A" //TODO: swap with the JWT you generated for Joe

var currentUser: NexmoUser? = null
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

val userName: String?
    get() = currentUser?.name

val otherUserName: String?
    get() = if (currentUser?.name == USER_NAME_JANE) USER_NAME_JOE else USER_NAME_JANE

val otherUserId: String
    get() = if (currentUser!!.name == USER_NAME_JANE) USER_ID_JOE else USER_ID_JANE

