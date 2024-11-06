package com.example.numgame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.numgame.R;
import com.example.numgame.activities.Home;
import com.example.numgame.src.UserManager;

public class Play extends Fragment {

    public Play() {
    }

    public static Play newInstance() {
        return new Play();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_play, container, false);

        ImageButton playButton = view.findViewById(R.id.playButton);

        playButton.setOnClickListener(v -> {
            Home parentActivity = (Home) getActivity();

            if (parentActivity != null) {
                String gameLevel = parentActivity.user.getGameLevel();

                switch (gameLevel) {
                    case "basic":
                        parentActivity.loadFragment(new Basic());
                        break;
                    case "intermediate":
                        parentActivity.loadFragment(new Intermediate());
                        break;
                    case "advanced":
                        parentActivity.loadFragment(new Advanced());
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }
}
