package com.example.vocarun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new LessonFragment();
    final Fragment fragment2 = new QuizFragment();
    final Fragment fragment3 = new ScoreboardFragment();
    final FragmentManager fm = getSupportFragmentManager();
    public int currentPoint = -1;
    public List<Score> scoreList = new ArrayList<>();
    public static final int QUESTION_REQUEST = 12;
    Fragment activeFragment = fragment1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_lesson:
                    fm.beginTransaction().hide(activeFragment).show(fragment1).commit();
                    activeFragment = fragment1;
                    return true;
                case R.id.navigation_quiz:
                    fm.beginTransaction().hide(activeFragment).show(fragment2).commit();
                    activeFragment = fragment2;
                    return true;
                case R.id.navigation_scoreboard:
                    fm.beginTransaction().hide(activeFragment).show(fragment3).commit();
                    activeFragment = fragment3;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lesson.initLesson();
        initFaKeScore();

        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void initFaKeScore() {
        scoreList.add(new Score("Long Vu Quynh Chau", 15));
        scoreList.add(new Score("Do Nhat Huy", 13));
        scoreList.add(new Score("Trinh Huu Duc", 20));
        scoreList.add(new Score("Nguyen Ngoc Minh Huy", 10));
        scoreList.add(new Score("Dao Hieu", 3));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == QUESTION_REQUEST && data != null) {
            if(resultCode == Activity.RESULT_OK){
                String resultPoint =data.getStringExtra("result");
//                Log.d("question point", resultPoint);
                currentPoint = Integer.parseInt(resultPoint);
                scoreList.add(new Score("YOU", currentPoint));
                Collections.sort(scoreList);
            }
//            if (resultCode == Activity.RESULT_CANCELED) {
//                //Write your code if there's no result
//            }
        }
    }

    public Boolean callQuestionActivity() {
        List<Lesson> hasStudy = new ArrayList<>();
        List<Lesson> lessonList = Lesson.lessonList;
        for (int i = 0; i < lessonList.size(); ++i) {
            if (lessonList.get(i).isOld == true) {
                hasStudy.add(lessonList.get(i));
            }
        }
        int studySize = hasStudy.size();
        if (studySize == 0) return false;
        int max = studySize - 1, min = 0;
        Random r = new Random();
        int randomNumber = r.nextInt(max - min + 1) + min;

        Intent i = new Intent(this, QuesstionActivity.class);
        i.putExtra("Lesson_name", hasStudy.get(randomNumber).name);
        this.startActivityForResult(i, QUESTION_REQUEST);
        return true;
    }

    public int getPoint() {
        return currentPoint;
    }
}
