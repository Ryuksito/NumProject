package com.example.numgame.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.numgame.R;
import com.example.numgame.activities.Home;

import java.util.Random;

public class Basic extends Fragment {

    int ranNum = -1;
    ImageView image;
    int successes = 0;

    public Basic() {
    }

    public static Basic newInstance() {
        return new Basic();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic, container, false);

        image = view.findViewById(R.id.image_view);
        changeNum(view);

        buttons(view);

        return view;
    }

    public void changeNum(View view){
        ranNum = generateRandomNumber();
        switch (ranNum) {
            case 0:
                image.setImageResource(R.drawable.zero);
                break;
            case 1:
                image.setImageResource(R.drawable.one);
                break;
            case 2:
                image.setImageResource(R.drawable.two);
                break;
            case 3:
                image.setImageResource(R.drawable.three);
                break;
            case 4:
                image.setImageResource(R.drawable.four);
                break;
            case 5:
                image.setImageResource(R.drawable.five);
                break;
            case 6:
                image.setImageResource(R.drawable.six);
                break;
            case 7:
                image.setImageResource(R.drawable.seven);
                break;
            case 8:
                image.setImageResource(R.drawable.eight);
                break;
            case 9:
                image.setImageResource(R.drawable.nine);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ranNum);
        }
    }

    public void buttons(View view){
        view.findViewById(R.id.btn_zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (0 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (1 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (2 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (3 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (4 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (5 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (6 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (7 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (8 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

        view.findViewById(R.id.btn_nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (9 == ranNum) {
                    succesIncrement(view);
                    changeNum(view);
                } else {
                    Home activity = (Home) getActivity();
                    assert activity != null;
                    activity.errorAudio();
                    activity.hearts = activity.hearts.substring(0, activity.hearts.length() - 1);
                    activity.editHearts.setText(activity.hearts);
                    if (!activity.hearts.isEmpty()) {
                        Toast.makeText(getContext(), "Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Game Over! Try again.", Toast.LENGTH_SHORT).show();
                    }
                    if(activity.hearts.isEmpty()){
                        activity.loadFragment(new Basic());
                        activity.hearts = "♥♥♥";
                        activity.editHearts.setText(activity.hearts);
                    }
                }
            }
        });

    }

    public void succesIncrement(View view){
        successes++;
        if(successes == 3){
            Toast.makeText(getContext(), "Level 1 passed, Congratulations!", Toast.LENGTH_SHORT).show();
            Home activity = (Home) getActivity();
            assert activity != null;
            activity.nextLevelAudio();
            activity.user.setGameLevel("intermediate");
            activity.loadFragment(new Play());
        }
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}