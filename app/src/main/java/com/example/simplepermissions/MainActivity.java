package com.example.simplepermissions;

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


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "doMagicTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
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