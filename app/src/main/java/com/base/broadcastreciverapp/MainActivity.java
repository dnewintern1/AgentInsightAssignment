package com.base.broadcastreciverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,  new String[]{android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.READ_CALL_LOG},1000 );
    }
}