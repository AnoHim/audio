package com.example.audio;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicPlayer {

    private static MediaPlayer mediaPlayer;

    public static void play(Context context, int resourceId) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        mediaPlayer = MediaPlayer.create(context, resourceId);
        mediaPlayer.start();
    }

    public static void stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}