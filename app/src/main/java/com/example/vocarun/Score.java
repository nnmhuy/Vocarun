package com.example.vocarun;

import java.util.List;

class Score implements Comparable<Score> {
    public String name;
    public int point;


    public Score(String name, int point) {
        this.name = name;
        this.point = point;
    }

    @Override
    public int compareTo(Score d) {
        return  d.point - this.point;
    }

}
