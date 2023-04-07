package ru.mirea.duplingv.activitylifecycle;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "function call: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "function call: onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "function call: onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "function call: onResume()");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "function call: onAttachedToWindow()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "function call: onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "function call: onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "function call: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "function call: onDestroy()");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, "function call: onDetachedFromWindow()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "function call: onRestart()");
    }

}