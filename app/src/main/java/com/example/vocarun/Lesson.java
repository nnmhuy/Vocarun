package com.example.vocarun;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    public String name;
    public int iconId;
    public Boolean isOld;
    public List<Word> wordList;

    public static List<Lesson> lessonList = new ArrayList<>();

    public Lesson(String name, int iconId, Boolean isOld, List<Word> wordList) {
        this.name = name;
        this.iconId = iconId;
        this.isOld = isOld;
        this.wordList = wordList;
    }

    public static void initLesson() {
        List<Word> animalWords = new ArrayList<>();
        animalWords.add(new Word("cat", "/kat/", R.drawable.cat, R.raw.cat));
        animalWords.add(new Word("dog", "/dôɡ/", R.drawable.dog, R.raw.dog));
        animalWords.add(new Word("bird", "/bərd/", R.drawable.bird, R.raw.bird));
        Lesson.lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));

        List<Word> vehicleWords = new ArrayList<>();
        vehicleWords.add(new Word("car", "/kär/", R.drawable.cat, R.raw.train));
        vehicleWords.add(new Word("bicycle", "/ˈbīsikəl/", R.drawable.bicycle, R.raw.bicycle));
        vehicleWords.add(new Word("train", "/treɪn/ ", R.drawable.train, R.raw.train));
        Lesson.lessonList.add(new Lesson("Vehicle", R.drawable.vehicle_lesson, false, vehicleWords));

        List<Word> schoolWords = new ArrayList<>();
        schoolWords.add(new Word("book", "/bo͝ok/", R.drawable.book, R.raw.book));
        schoolWords.add(new Word("pencil", "/ˈpensəl/", R.drawable.pencil, R.raw.pencil));
        schoolWords.add(new Word("eraser", "/əˈrāsər/", R.drawable.eraser, R.raw.eraser));
        Lesson.lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));

        List<Word> bodyWords = new ArrayList<>();
        vehicleWords.add(new Word("hand", "/hand/", R.drawable.hand, R.raw.hand));
        vehicleWords.add(new Word("mouth", "/maʊθ/", R.drawable.bicycle, R.raw.bicycle));
        vehicleWords.add(new Word("ear", "/ɪr/", R.drawable.ear, R.raw.ear));
        Lesson.lessonList.add(new Lesson("Body Parts", R.drawable.body_parts_lesson, true, bodyWords));


        List<Word> kitchenWords = new ArrayList<>();
        kitchenWords.add(new Word("bowl", "/bōl/", R.drawable.bowl, R.raw.bowl));
        kitchenWords.add(new Word("dish", "/diSH/", R.drawable.dish, R.raw.dish));
        kitchenWords.add(new Word("spoon", "/spo͞on/", R.drawable.spoon, R.raw.spoon));
        Lesson.lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
    }
}
