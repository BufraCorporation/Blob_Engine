package com.corporation.bufra.blob_engine;

import com.corporation.bufra.blob_engine.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.sql.Blob;

public class FullscreenActivity extends Activity {
    Button oButton, eButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        //OpenGL start
        oButton = (Button) findViewById(R.id.button);
        oButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(FullscreenActivity.this, MainActivity.class));

            }
        });

        //Einstellungen öffnen
        eButton = (Button)findViewById(R.id.button2);
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FullscreenActivity.this, EinstellungenActivity.class));
            }
        });
    }

//
//    //Optionsmenü
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            startActivity(new Intent(this, EinstellungenActivity.class));
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
