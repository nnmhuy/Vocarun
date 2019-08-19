package com.example.vocarun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class StudyLesson extends AppCompatActivity {
    Lesson currentLesson;
    Button startButton;
    Button backButton;
    ConstraintLayout wordItem;
    TextView wordText, pronunciationText, processText;
    ImageView wordImage;
    final Context context = this;

    private final Timer timer = new Timer();
    private final TimerTask wordSlideTask = new TimerTask() {
        private int counter = 0;
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    if (counter < currentLesson.wordList.size()) {
                        Word currentWord = currentLesson.wordList.get(counter);
                        processText.setText(String.format("%d/%d", counter + 1, currentLesson.wordList.size()));
                        wordText.setText(currentWord.word);
                        pronunciationText.setText(currentWord.pronunciation);
                        wordImage.setBackgroundResource(currentWord.imageId);
                        MediaPlayer mp = MediaPlayer.create(context, currentWord.pronounceId);
                        mp.start();
                        startTimer();
                    }
                    ++counter;
                    if(counter >= currentLesson.wordList.size() + 1) {
                        timer.cancel();

                        wordItem.clearAnimation();
                        wordItem.setVisibility(View.INVISIBLE);

                        backButton.clearAnimation();
                        backButton.setVisibility(View.VISIBLE);
                    }

                }
            });
        }
    };
    private CountDownTimer countDownTimer;
    private ProgressBar progressBar;

    private void startTimer() {
        countDownTimer = new CountDownTimer(3 * 1000, 50) {
            // 500 means, onTick function will be called at every 500 milliseconds

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = (long)((leftTimeInMilliseconds / 3000.0) * 100);
                progressBar.setProgress((int)seconds);
            }
            @Override
            public void onFinish() {

            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCurrentLesson();
        setContentView(R.layout.activity_study_lesson);

        progressBar = findViewById(R.id.timer);

        TextView lessonName = findViewById(R.id.lesson_name);
        lessonName.setText(currentLesson.name);

        startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLesson();
            }
        });

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        processText = findViewById(R.id.process);
        processText.setText(String.format("%d/%d", 0, currentLesson.wordList.size()));

        wordItem = findViewById(R.id.word_item);
        wordText = findViewById(R.id.word);
        pronunciationText = findViewById(R.id.pronunciation);
        wordImage = findViewById(R.id.word_image);
    }

    private void startLesson() {
        startButton.clearAnimation();
        startButton.setVisibility(View.INVISIBLE);
        Log.println(Log.VERBOSE, "checkpoint", "start");

        wordItem.clearAnimation();
        wordItem.setVisibility(View.VISIBLE);

        timer.schedule(wordSlideTask, 0, 3000);
    }

    void getCurrentLesson() {
        Intent intent = getIntent();
        String lessonName = intent.getStringExtra("lessonName");
        List<Lesson> lessonList = Lesson.lessonList;
        for (int i = 0; i < lessonList.size(); ++i) {
            if (lessonList.get(i).name.equals(lessonName)) {
                currentLesson = lessonList.get(i);
                break;
            }
        }
    }
}
