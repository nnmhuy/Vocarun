package com.example.vocarun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new LessonFragment();
    final Fragment fragment2 = new QuizFragment();
    final Fragment fragment3 = new ScoreboardFragment();
    final FragmentManager fm = getSupportFragmentManager();
    public int currentPoint = -1;
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

        initLesson();

        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void initLesson() {
        List<Word> animalWords = new ArrayList<>();
        animalWords.add(new Word("cat", "/kat/", R.drawable.cat, R.raw.cat));
        animalWords.add(new Word("dog", "/dôɡ/", R.drawable.dog, R.raw.dog));
        animalWords.add(new Word("bird", "/bərd/", R.drawable.bird, R.raw.bird));
        Lesson.lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, true, animalWords));

        List<Word> kitchenWords = new ArrayList<>();
        kitchenWords.add(new Word("bowl", "/bōl/", R.drawable.bowl, R.raw.bowl));
        kitchenWords.add(new Word("dish", "/diSH/", R.drawable.dish, R.raw.dish));
        kitchenWords.add(new Word("spoon", "/spo͞on/", R.drawable.spoon, R.raw.spoon));
        Lesson.lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, true, kitchenWords));

        List<Word> schoolWords = new ArrayList<>();
        schoolWords.add(new Word("book", "/bo͝ok/", R.drawable.book, R.raw.book));
        schoolWords.add(new Word("pencil", "/ˈpensəl/", R.drawable.pencil, R.raw.pencil));
        schoolWords.add(new Word("eraser", "/əˈrāsər/", R.drawable.eraser, R.raw.eraser));
        Lesson.lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));


        Lesson.lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        Lesson.lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));
        Lesson.lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));

        Lesson.lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        Lesson.lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        Lesson.lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));

        Lesson.lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));
        Lesson.lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        Lesson.lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));

        Lesson.lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        Lesson.lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        Lesson.lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));

        Lesson.lessonList.add(new Lesson("Kitchen", R.drawable.kitchen_lesson, false, kitchenWords));
        Lesson.lessonList.add(new Lesson("School", R.drawable.school, false, schoolWords));
        Lesson.lessonList.add(new Lesson("Animal", R.drawable.animal_lesson, false, animalWords));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == QUESTION_REQUEST && data != null) {
            if(resultCode == Activity.RESULT_OK){
                String resultPoint =data.getStringExtra("result");
//                Log.d("question point", resultPoint);
                currentPoint = Integer.parseInt(resultPoint);
            }
//            if (resultCode == Activity.RESULT_CANCELED) {
//                //Write your code if there's no result
//            }
        }
    }

    public void callQuestionActivity() {
        Intent i = new Intent(this, QuesstionActivity.class);
        i.putExtra("Lesson_name", "Animal");
        this.startActivityForResult(i, QUESTION_REQUEST);
    }

    public int getPoint() {
        return currentPoint;
    }
}
