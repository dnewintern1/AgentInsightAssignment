package com.base.broadcastreciverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class IncomingCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_call); // Create a layout XML file for this activity

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Incoming Call");
        builder.setMessage("You have an incoming call.");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                restorePreviousActivityStateAndResume();
                finish(); // Close the activity

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void restorePreviousActivityStateAndResume() {
        SharedPreferences preferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE);
        String lastActivityClassName = preferences.getString("lastActivity", null);

        if (lastActivityClassName != null) {
            try {
                // Use reflection to create an intent for the previous activity
                Class<?> lastActivityClass = Class.forName(lastActivityClassName);
                Intent intent = new Intent(this, lastActivityClass);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}