package com.example.charades.activities;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.example.charades.R;

public class SoundEffects {
    AudioAttributes audioAttributes;
    final int MAX = 1;
    int s1, s2, s3, s4, s5, s6;

    static int wrong_sound;
    static int correct_sound;
    static int game_end_sound;
    static int game_start_sound;
    static int finish_sound;
    static int end_beep_sound;

    static SoundPool soundPool;

    public SoundEffects(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(MAX)
                    .build();
        } else {
            soundPool = new SoundPool(MAX, AudioManager.STREAM_MUSIC, 1);
        }

        wrong_sound = soundPool.load(context, R.raw.wrong_sound, 1);
        correct_sound = soundPool.load(context, R.raw.correct_sound, 1);
        game_end_sound = soundPool.load(context, R.raw.game_end_sound, 1);
        game_start_sound = soundPool.load(context, R.raw.game_start_sound, 1);
        finish_sound = soundPool.load(context, R.raw.finish, 1);
        end_beep_sound = soundPool.load(context, R.raw.game_start_sound_beep, 1);
    }

    public void wrongSound() {
        s1 = soundPool.play(wrong_sound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void correctSound() {
        s2 = soundPool.play(correct_sound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void gameEndSound() {
        s3 = soundPool.play(game_end_sound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void gameStartSound() {
        s4 = soundPool.play(game_start_sound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void gameBeepSound() {
        s5 = soundPool.play(end_beep_sound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void finishSound() {
        s6 = soundPool.play(finish_sound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void endSound() {
        soundPool.stop(s1);
        soundPool.stop(s2);
        soundPool.stop(s3);
        soundPool.stop(s4);
        soundPool.stop(s5);
        soundPool.stop(s6);
    }
}
