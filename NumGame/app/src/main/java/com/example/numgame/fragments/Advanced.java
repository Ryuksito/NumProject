package com.example.numgame.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.numgame.R;
import com.example.numgame.activities.Home;

import java.util.ArrayList;
import java.util.Random;

public class Advanced extends Fragment {

    ArrayList<Integer> randNumbers = new ArrayList<>();
    ArrayList<Integer> userNumbers = new ArrayList<>();
    int successes = 0;

    ImageView image;

    boolean isAnimation = false;
    int currentIndex = 0;

    public Advanced() {
    }

    public static Advanced newInstance(String param1, String param2) {
        return new Advanced();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advanced, container, false);

        image = view.findViewById(R.id.image_view);
        buttons(view);
        changeSequence(view);

        return view;
    }

    public void changeSequence(View view){
        userNumbers.clear();
        randNumbers.clear();
        randNumbers = generateRandomSequence();

        animation();
    }

    public void animation(){
        isAnimation = true;
        currentIndex = 0;

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentIndex < randNumbers.size()) {
                    int number = randNumbers.get(currentIndex);
                    image.setImageResource(number2img(number));
                    currentIndex++;
                    handler.postDelayed(this, 700);
                } else {
                    isAnimation = false;
                }
            }
        };

        handler.post(runnable);
    }

    public int number2img(int num) {
        int img = R.drawable.zero;
        switch (num) {
            case 0:
                img = R.drawable.zero;
                break;
            case 1:
                img = R.drawable.one;
                break;
            case 2:
                img = R.drawable.two;
                break;
            case 3:
                img = R.drawable.three;
                break;
            case 4:
                img = R.drawable.four;
                break;
            case 5:
                img = R.drawable.five;
                break;
            case 6:
                img = R.drawable.six;
                break;
            case 7:
                img = R.drawable.seven;
                break;
            case 8:
                img = R.drawable.eight;
                break;
            case 9:
                img = R.drawable.nine;
                break;
        }
        return img;
    }

    public void buttons(View view) {
        view.findViewById(R.id.btn_zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,0);
            }
        });
        view.findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,1);
            }
        });
        view.findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,2);
            }
        });
        view.findViewById(R.id.btn_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,3);
            }
        });
        view.findViewById(R.id.btn_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,4);
            }
        });
        view.findViewById(R.id.btn_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,5);
            }
        });
        view.findViewById(R.id.btn_six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,6);
            }
        });
        view.findViewById(R.id.btn_seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,7);
            }
        });
        view.findViewById(R.id.btn_eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view,8);
            }
        });
        view.findViewById(R.id.btn_nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserNumbers(view, 9);
            }
        });
    }

    public void updateUserNumbers(View view, int num){
        if(isAnimation){
            return;
        }
        userNumbers.add(num);
        if(userNumbers.size() >= randNumbers.size()){
            if(randNumbers.equals(userNumbers)){
                succesIncrement(view);
                changeSequence(view);
            }else{
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
                }else{
                    changeSequence(view);
                }
            }
        }
    }

    public static ArrayList<Integer> generateRandomSequence() {
        Random random = new Random();
        int sequenceLength = random.nextInt(5) + 3;

        ArrayList<Integer> sequence = new ArrayList<>();
        while (sequence.size() < sequenceLength) {
            int randomNum = random.nextInt(10);
            if (!sequence.contains(randomNum)) {
                sequence.add(randomNum);
            }
        }
        return sequence;
    }

    public void succesIncrement(View view){
        successes++;
        if(successes == 3){
            Toast.makeText(getContext(), "Level 3 passed, Congratulations!", Toast.LENGTH_SHORT).show();
            Home activity = (Home) getActivity();
            assert activity != null;
            activity.nextLevelAudio();
            activity.user.setGameLevel("basic");
            activity.loadFragment(new Play());
        }
    }
}
