package com.example.numgame.activities;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.numgame.R;
import com.example.numgame.fragments.Advanced;
import com.example.numgame.fragments.Basic;
import com.example.numgame.fragments.Intermediate;
import com.example.numgame.fragments.Play;
import com.example.numgame.src.UserManager;

import java.util.Objects;

public class Home extends AppCompatActivity {

    public UserManager user;
    public String hearts = "♥♥♥";
    public TextView editHearts;
    public TextView level;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.appBar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("NumGame");

        editHearts = findViewById(R.id.livesText);
        level = findViewById(R.id.level);

        user = UserManager.getInstance();
        level.setText(user.getGameLevel());


        loadFragment(new Play());
    }

    public void setSystemVolume() {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioManager != null) {
            int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);
        }
    }

    public void nextLevelAudio() {
        setSystemVolume();

        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.win);
        mediaPlayer.start();
    }

    public void errorAudio() {
        setSystemVolume();

        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.error);
        mediaPlayer.start();
    }

    public void loadFragment(Fragment fragment) {
        if(fragment instanceof Basic){
            level.setText("basic");
        } else if (fragment instanceof Intermediate) {
            level.setText("intermediate");
        } else if (fragment instanceof  Advanced) {
            level.setText("advanced");
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}