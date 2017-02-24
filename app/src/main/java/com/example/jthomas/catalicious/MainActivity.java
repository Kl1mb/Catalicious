package com.example.jthomas.catalicious;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool meow1;
    int meow1id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            meow1 = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(aa)
                    .build();

            meow1id = meow1.load(this, R.raw.meow1,1);
        } else
            meow1 = new SoundPool(10, AudioManager.STREAM_MUSIC,1);
        meow1id = meow1.load(this, R.raw.meow1,1);

        }
    public void PlaySound(View view) {meow1.play(meow1id,1,1,1,0,1);
    }

    }
