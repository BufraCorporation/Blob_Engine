package com.corporation.bufra.blob_engine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.corporation.bufra.blob_engine.OpenGL.MainRenderer;
import com.corporation.bufra.blob_engine.OpenGL.shapes.Triangle;

/**
 * Created by Clemens on 01.08.2015.
 */
public class EinstellungenActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        Preference colorPref = findPreference(getString(R.string.preference_color_key));
        colorPref.setOnPreferenceChangeListener(this);

        //SharedPreferences ändern
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String preferenceString = sharedPrefs.getString(colorPref.getKey(), "");
        onPreferenceChange(colorPref, preferenceString);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value){
        switch (Integer.valueOf(value.toString())){
            case 1:
                MainActivity.getRenderer().setColor(0.8f, 0.0f, 0.0f, 1.0f);
                break;
            case 2:
                MainActivity.getRenderer().setColor(0.0f, 1.0f, 0.0f, 1.0f);
                break;
            case 3:
                MainActivity.getRenderer().setColor(0.0f, 0.0f, 1.0f, 1.0f);
                break;
            case 4:
                MainActivity.getRenderer().setColor(0.36f, 0.15f, 0.0f, 1.0f);
                break;
        }

        return true;
    }

}
