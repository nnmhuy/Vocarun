package com.example.vocarun;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new LessonFragment();
    final Fragment fragment2 = new QuizFragment();
    final Fragment fragment3 = new ScoreboardFragment();
    final FragmentManager fm = getSupportFragmentManager();
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

        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
