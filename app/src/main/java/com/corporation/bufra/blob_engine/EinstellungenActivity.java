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
    static private String preferenceString, recColorPreferenceString;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        Preference colorPref = findPreference(getString(R.string.preference_color_key));
        colorPref.setOnPreferenceChangeListener(this);

        Preference recColorPref = findPreference(getString(R.string.preference_recCol_key));
        recColorPref.setOnPreferenceChangeListener(this);

        //SharedPreferences

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        preferenceString = sharedPrefs.getString(colorPref.getKey(), "");
        onPreferenceChange(colorPref, preferenceString);

        recColorPreferenceString = sharedPrefs.getString(recColorPref.getKey(), "");
        onPreferenceChange(recColorPref, recColorPreferenceString);
    }

    static public int getColor(){
        return Integer.valueOf(preferenceString);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value){
        switch (Integer.valueOf(value.toString())){
            //Hintergrundfarbe:
            case 1: //Rot
                MainActivity.getRenderer().setColor(0.5f, 0.0f, 0.0f, 1.0f);
                break;
            case 2: //Grün
                MainActivity.getRenderer().setColor(0.27f, 1.0f, 0.27f, 1.0f);
                break;
            case 3: //Blau
                MainActivity.getRenderer().setColor(0.27f, 0.47f, 1.0f, 1.0f);
                break;
            case 4: //Kackbraun
                MainActivity.getRenderer().setColor(0.36f, 0.15f, 0.0f, 1.0f);
                break;
            case 5: //Smoothes Orange:
                MainActivity.getRenderer().setColor(1.0f, 0.5f, 0.0f, 1.0f);
                break;

            //Rectanglefarbe:
            case 10: //88, 50, 95 - Blasengummi
                Triangle.setColor(0.88f, 0.5f,0.95f, 1.0f);
                break;
            case 11: //55, 95, 30 - Frühling
                Triangle.setColor(0.55f, 0.95f, 0.3f, 1.0f);
                break;
            case 12: //55, 50, 95 - Orchidee
                Triangle.setColor(0.55f, 0.5f, 0.95f, 1.0f);
                break;
        }

        return true;
    }

}
