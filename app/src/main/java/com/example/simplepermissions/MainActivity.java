package com.example.simplepermissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import android.Manifest;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "doMagicTAG_";
    private static final int CODE_CONSTANT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "doMagic: " + "doMagic Permission Denied");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    CODE_CONSTANT);
        } else {
            Log.d(TAG, "doMagic: " + "doMagic Permission Granted");
            writeTimeExternal();
        }
    }

    //prompt usesr to allow permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CODE_CONSTANT:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "onRequestPermissionsResult: " + "ReadMagic Permission Granted");
                    writeTimeExternal();
                } else {
                    Log.d(TAG, "onRequestPermissionsResult: " + "ReadMagic Permission Denied");
                }
        }
    }

    public void writeTimeExternal() {
        File file = android.os.Environment.getExternalStorageDirectory();

        File aux = new File(file, "hello.txt");

        try {
            FileOutputStream fileoutputstream = new FileOutputStream(aux);
            PrintWriter printwriter = new PrintWriter(fileoutputstream);
            printwriter.println(System.currentTimeMillis());
            printwriter.flush();
            printwriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "doMagic: " + file);
        Log.d(TAG, "doMagic: " + aux);
    }

    public void readMagic(View view) {
        readFileExternal();
    }

    public void readFileExternal() {
        File file = android.os.Environment.getExternalStorageDirectory();
        File aux = new File(file, "hello.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(aux);
            Scanner scanner = new Scanner(fileInputStream);
            Log.d(TAG, "readMagic: " + scanner.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}