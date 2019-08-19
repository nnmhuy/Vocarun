package com.example.vocarun;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


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
                if (!((MainActivity) getActivity()).callQuestionActivity()) {
                    Context context = getActivity().getApplicationContext();
                    CharSequence text = "You must study a lesson first";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                };
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
