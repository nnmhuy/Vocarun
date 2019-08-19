package com.example.vocarun;

import android.graphics.Bitmap;

public class Word {
    public String word;
    public String pronunciation;
    public int imageId;
    public int pronounceId;

    public Word(String word, int imageId) {
        this.word = word;
        this.imageId = imageId;
    }

    public Word(String word, String pronunciation, int imageId) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.imageId = imageId;
    }

    public Word(String word, String pronunciation, int imageId, int pronounceId) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.imageId = imageId;
        this.pronounceId = pronounceId;
    }
}
