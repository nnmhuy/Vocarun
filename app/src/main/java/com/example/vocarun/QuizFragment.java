package com.example.vocarun;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    public  View view;
    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_quiz, container, false);


        Button button = view.findViewById(R.id.startQuession);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).callQuestionActivity();
            }
        });

        return  this.view;
    }

    @Override
    public void onResume(){
        super.onResume();
        int currentPoint = ((MainActivity) getActivity()).getPoint();
        TextView pointText = this.view.findViewById(R.id.currentPointText);
        if (currentPoint == -1) {
            pointText.setText("Have fun!");
        } else {
            String pointString = "Previous Point: " + String.valueOf(currentPoint);
            pointText.setText(pointString);
        }

    }
}
