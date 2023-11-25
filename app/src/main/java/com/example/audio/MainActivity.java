package com.example.audio;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView musicListView;
    private Button playButton;

    private int[] musicList = {
            R.raw.blow,
            R.raw.jamik,
            R.raw.mafia,
            R.raw.sever,
            R.raw.yd,
            // Добавьте остальные музыкальные файлы
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicListView = findViewById(R.id.musicListView);
        playButton = findViewById(R.id.playButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.music_titles));
        musicListView.setAdapter(adapter);

        musicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedMusic = musicList[position];
                MusicPlayer.play(MainActivity.this, selectedMusic);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicPlayer.stop();
            }
        });
    }
}