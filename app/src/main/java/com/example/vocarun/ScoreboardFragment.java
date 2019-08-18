package com.example.vocarun;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreboardFragment extends Fragment {
    private List<Score> scoreList = new ArrayList<>();
    RecyclerView recyclerView;

    public ScoreboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                             // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scoreboard, container, false);

        initFaKeScore();

        recyclerView = (RecyclerView) view.findViewById(R.id.scoreboardRecycleView);
        ScoreAdapter scoreAdapter = new ScoreAdapter(getActivity(), scoreList);
        recyclerView.setAdapter(scoreAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    private void initFaKeScore() {
        scoreList.add(new Score("Long Vu Quynh Chau", 40));
        scoreList.add(new Score("Do Nhat Huy", 38));
        scoreList.add(new Score("Trinh Huu Duc", 38));
        scoreList.add(new Score("Nguyen Ngoc Minh Huy", 35));
        scoreList.add(new Score("Dao Hieu", 20));
    }

}
