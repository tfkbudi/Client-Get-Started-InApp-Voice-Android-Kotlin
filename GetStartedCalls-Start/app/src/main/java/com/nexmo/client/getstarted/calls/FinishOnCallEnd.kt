package com.nexmo.client.getstarted.calls

import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.nexmo.client.NexmoCallEventListener
import com.nexmo.client.NexmoCallMember
import com.nexmo.client.NexmoCallMemberStatus
import com.nexmo.client.NexmoMediaActionState

import java.lang.ref.WeakReference

class FinishOnCallEnd(activity: AppCompatActivity) : NexmoCallEventListener {
    private val activityRef: WeakReference<AppCompatActivity> = WeakReference(activity)

    override fun onMemberStatusUpdated(nexmoCallStatus: NexmoCallMemberStatus, nexmoCallMember: NexmoCallMember) {
        if (nexmoCallStatus == NexmoCallMemberStatus.COMPLETED || nexmoCallStatus == NexmoCallMemberStatus.CANCELED) {
            activityRef.get()?.finish()
        }
    }

    override fun onMuteChanged(nexmoMediaActionState: NexmoMediaActionState, nexmoCallMember: NexmoCallMember) {
        Log.d(TAG, "NexmoCallEventListener.onMuteChanged: " + nexmoCallMember.user.name + " : " + nexmoMediaActionState)

    }

    override fun onEarmuffChanged(nexmoMediaActionState: NexmoMediaActionState, nexmoCallMember: NexmoCallMember) {
        Log.d(TAG, "NexmoCallEventListener.onEarmuffChanged: " + nexmoCallMember.user.name + " : " + nexmoMediaActionState)
    }

    override fun onDTMF(dtmf: String, callMember: NexmoCallMember) {
        Log.d(TAG, "NexmoCallEventListener.onDTMF: " + callMember.user.name + " : " + dtmf)
    }
}
