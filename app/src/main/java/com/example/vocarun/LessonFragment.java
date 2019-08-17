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
    private List<Lesson> lessonList = new ArrayList<>();
    RecyclerView recyclerView;

    public LessonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);

        initLesson();

        recyclerView = (RecyclerView) view.findViewById(R.id.lessonRecyclerView);
        LessonAdapter lessonAdapter = new LessonAdapter(getActivity(), lessonList);
        recyclerView.setAdapter(lessonAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return view;
    }

    public void initLesson() {
        List<Word> animalWords = new ArrayList<>();
        animalWords.add(new Word("cat", R.drawable.cat));
        animalWords.add(new Word("dog", R.drawable.dog));
        animalWords.add(new Word("bird", R.drawable.bird));
        lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, true, animalWords));

        List<Word> kitchenWords = new ArrayList<>();
        animalWords.add(new Word("cat", R.drawable.bowl));
        animalWords.add(new Word("dish", R.drawable.dish));
        animalWords.add(new Word("spoon", R.drawable.spoon));
        lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, true, kitchenWords));

        List<Word> schoolWords = new ArrayList<>();
        animalWords.add(new Word("book", R.drawable.book));
        animalWords.add(new Word("pencil", R.drawable.pencil));
        animalWords.add(new Word("eraser", R.drawable.eraser));
        lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));


        lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));
        lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));

        lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));

        lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));
        lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));

        lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));

        lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));
    }

}
