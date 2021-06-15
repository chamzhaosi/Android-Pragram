package com.example.neweramay2021_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class infoActivity extends AppCompatActivity {

    private Button btnGoToWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        findView();
        setListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getClass().getSimpleName(), "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getClass().getSimpleName(), "onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getClass().getSimpleName(), "onDestroy()");
    }

    private void findView(){
        btnGoToWebsite = findViewById(R.id.btnGoTowebsite);
    }

    private void setListener(){
        btnGoToWebsite.setOnClickListener(view ->{
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(websiteIntent);
        });
    }
}