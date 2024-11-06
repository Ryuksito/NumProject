package com.example.numgame.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.numgame.R;
import com.example.numgame.activities.Home;

import java.util.ArrayList;
import java.util.Random;

public class Intermediate extends Fragment {

    ArrayList<Integer> randNumbers = new ArrayList<>();
    int successes = 0;
    int maxNumber = 0;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;

    public Intermediate() {
    }

    public static Intermediate newInstance(String param1, String param2) {
        return new Intermediate();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intermediate, container, false);

        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);
        image3 = view.findViewById(R.id.image3);
        image4 = view.findViewById(R.id.image4);

        changeNums(view);


        buttons(view);

        return view;
    }

    public void buttons(View view){
        view.findViewById(R.id.btn_zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (0 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (1 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (2 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (3 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (4 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (5 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (6 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (7 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (8 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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
                if (9 == maxNumber) {
                    succesIncrement(view);
                    changeNums(view);
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

    public void changeNums(View view){

        randNumbers.clear();
        maxNumber = 0;

        Random random = new Random();

        while (randNumbers.size() < 4) {
            int randomNum = random.nextInt(10); // Genera números entre 0 y 9
            if (!randNumbers.contains(randomNum)) {
                randNumbers.add(randomNum);
            }
        }

        setRandomImage(image1, 0);
        setRandomImage(image2, 1);
        setRandomImage(image3, 2);
        setRandomImage(image4, 3);

        for (int i = 0; i < randNumbers.size(); i++) {
            if (randNumbers.get(i) > maxNumber) {
                maxNumber = randNumbers.get(i);
            }
        }
    }

    private void setRandomImage(ImageView imageView, int index) {
        int randomNum = randNumbers.get(index);
        switch (randomNum) {
            case 0:
                imageView.setImageResource(R.drawable.zero);
                break;
            case 1:
                imageView.setImageResource(R.drawable.one);
                break;
            case 2:
                imageView.setImageResource(R.drawable.two);
                break;
            case 3:
                imageView.setImageResource(R.drawable.three);
                break;
            case 4:
                imageView.setImageResource(R.drawable.four);
                break;
            case 5:
                imageView.setImageResource(R.drawable.five);
                break;
            case 6:
                imageView.setImageResource(R.drawable.six);
                break;
            case 7:
                imageView.setImageResource(R.drawable.seven);
                break;
            case 8:
                imageView.setImageResource(R.drawable.eight);
                break;
            case 9:
                imageView.setImageResource(R.drawable.nine);
                break;
        }
    }

    public void succesIncrement(View view){
        successes++;
        if(successes == 3){
            Toast.makeText(getContext(), "Level 2 passed, Congratulations!", Toast.LENGTH_SHORT).show();
            Home activity = (Home) getActivity();
            assert activity != null;
            activity.nextLevelAudio();
            activity.user.setGameLevel("advanced");
            activity.loadFragment(new Play());
        }
    }
}