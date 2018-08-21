package com.example.devansh.demoprojectoath.Activities;

import android.os.Bundle;
import android.app.Activity;

import com.example.devansh.demoprojectoath.R;

public class Webview_news extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_news);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
