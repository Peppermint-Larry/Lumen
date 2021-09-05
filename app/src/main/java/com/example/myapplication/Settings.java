package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    ImageButton back;
    Switch gestures;
    Switch sound;
    Switch vibration;
    boolean soundOn;
    boolean gesturesOn;
    boolean vibrationOn;

    public static Intent makeIntent(Context context) {
        return new Intent(context, Settings.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);

                intent.putExtra("sound", soundOn);
                intent.putExtra("gestures", gesturesOn);
                intent.putExtra("vibration", vibrationOn);
                startActivity(intent);

            }
        });

        gestures = findViewById(R.id.gestures);
        sound = findViewById(R.id.sound);
        vibration = findViewById(R.id.vibration);

        SharedPreferences gesturePref = getSharedPreferences("save", MODE_PRIVATE);
        gestures.setChecked(gesturePref.getBoolean("value", true));

        SharedPreferences soundPref = getSharedPreferences("save", MODE_PRIVATE);
        sound.setChecked(soundPref.getBoolean("value", true));

        SharedPreferences vibePref = getSharedPreferences("save", MODE_PRIVATE);
        vibration.setChecked(vibePref.getBoolean("value", true));

        gestures.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if (gestures.isChecked()){
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    gestures.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    gestures.setChecked(false);
                }
            }

        });

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sound.isChecked()){
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    sound.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    sound.setChecked(false);
                }
            }
        });

        vibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vibration.isChecked()){
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    vibration.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    vibration.setChecked(false);
                }
            }
        });
    }


}