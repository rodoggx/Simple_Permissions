package com.example.simplepermissions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "doMagicTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        File file = android.os.Environment.getExternalStorageDirectory();
        Log.d(TAG, "doMagic: " + file);

    }
}
