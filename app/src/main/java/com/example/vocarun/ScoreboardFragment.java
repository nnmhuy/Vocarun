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

    RecyclerView recyclerView;
    ScoreAdapter scoreAdapter;

    public ScoreboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                             // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scoreboard, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.scoreboardRecycleView);
        scoreAdapter = new ScoreAdapter(getActivity(), ((MainActivity) getActivity()).scoreList);
        recyclerView.setAdapter(scoreAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;
    }



    @Override
    public void onResume(){
        super.onResume();
        scoreAdapter.notifyDataSetChanged();
    }
}
