package com.artofjeam.famb;

/**
 * Created by jeam999 on 29.05.2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends FragmentActivity implements View.OnClickListener {
    Button media,browser;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        media=(Button)findViewById(R.id.Media);
        browser=(Button)findViewById(R.id.Browser);

        media.setOnClickListener(this);
        browser.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Media:
                // ОК button
                intent = new Intent(this, Media.class);
                startActivity(intent);
                break;
            case R.id.Browser:
                // Cancel button
                intent = new Intent(this, Browser.class);
                startActivity(intent);
                break;
        }
    }
}