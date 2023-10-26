package com.base.broadcastreciverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;


public class PhoneCallReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String phoneState = bundle.getString(TelephonyManager.EXTRA_STATE);

            if (phoneState != null && phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                // Save the current app state using SharedPreferences
                saveAppState(context);

                // Start the IncomingCallActivity
                Intent incomingCallIntent = new Intent(context, IncomingCallActivity.class);
                incomingCallIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(incomingCallIntent);
            }
        }
    }

    private void saveAppState(Context context) {
        // Use SharedPreferences to save app state data
        SharedPreferences preferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Save relevant app state data
        // For example, save the current activity or fragment state
        editor.putString("PhoneCallReciever", getClass().getName()); // Replace with your own data

        editor.apply();
    }
}