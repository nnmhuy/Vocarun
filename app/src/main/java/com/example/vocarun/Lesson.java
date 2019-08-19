package com.example.vocarun;

import android.graphics.Bitmap;

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
}
