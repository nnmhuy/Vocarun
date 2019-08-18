package com.example.vocarun;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LessonFragment extends Fragment {
    private List<Lesson> lessonList = Lesson.lessonList;
    RecyclerView recyclerView;

    public LessonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.lessonRecyclerView);
        LessonAdapter lessonAdapter = new LessonAdapter(getActivity(), lessonList);
        recyclerView.setAdapter(lessonAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return view;
    }

}
