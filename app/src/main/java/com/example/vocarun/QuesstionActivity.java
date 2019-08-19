package com.example.vocarun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuesstionActivity extends Activity {
    public  String lessonName;
    public int newPoint = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        this.lessonName = intent.getStringExtra("Lesson_name");

        Button buttonEnd = findViewById(R.id.questionEnd);
        buttonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnMainActivity();
            }
        });
    }

    private void returnMainActivity() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",String.valueOf(newPoint));
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
