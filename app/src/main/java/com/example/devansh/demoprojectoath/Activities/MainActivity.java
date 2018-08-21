package com.example.devansh.demoprojectoath.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.devansh.demoprojectoath.API.APIConstants;
import com.example.devansh.demoprojectoath.Adapters.Main_list_adapter;
import com.example.devansh.demoprojectoath.Parser.GetData;
import com.example.devansh.demoprojectoath.R;

public class MainActivity extends AppCompatActivity {

    public ListView news_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        news_list = (ListView) findViewById(R.id.main_list_view);
        new GetData().execute();
        System.out.println(APIConstants.list);
        Main_list_adapter adapter = new Main_list_adapter(this.getApplicationContext(),R.layout.display_adapter, APIConstants.list);
        news_list.setAdapter(adapter);

        news_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                APIConstants.list.get(i).getWeb_url();
                //Intent i = new Intent(this,Webview_news.class);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
