package com.example.vocarun;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {
    List<Lesson> lessonList;
    LayoutInflater layoutInflater;
    Activity activity;

    public LessonAdapter(Context context, List<Lesson> lessonList) {
        layoutInflater = LayoutInflater.from(context);
        activity = (Activity)context;
        this.lessonList = lessonList;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View LessonView;

        LessonView = layoutInflater.inflate(R.layout.lesson_box, parent, false);

        return new LessonViewHolder(LessonView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, final int position) {
        final Lesson currentLesson = lessonList.get(position);

        holder.lessonTitle.setText(currentLesson.name);
        holder.lessonIcon.setImageResource(currentLesson.iconId);
        if (currentLesson.isOld) {
            holder.holderView.setBackgroundResource(R.drawable.studied_border);
        } else {
            holder.holderView.setBackgroundResource(R.drawable.border);
        }

        holder.holderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, StudyLesson.class);
                intent.putExtra("lessonName", currentLesson.name);
                lessonList.get(position).isOld = true;
                activity.startActivityForResult(intent, 11);
                notifyDataSetChanged();
            }
        });
//        holder.playButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(activity, StudyLesson.class);
//                intent.putExtra("lesson", currentLesson.toString());
//                intent.putExtra("studyMode", "play");
//                activity.startActivityForResult(intent, 11);
//            }
//        });

//        holder.replayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(activity, StudyLesson.class);
//                intent.putExtra("lesson", currentLesson.toString());
//                intent.putExtra("studyMode", "replay");
//                activity.startActivityForResult(intent, 12);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public class LessonViewHolder extends RecyclerView.ViewHolder {
        public final View holderView;
        public final TextView lessonTitle;
        public final ImageView lessonIcon;
//        public final ImageView playButton;
//        public final ImageView replayButton;
        final LessonAdapter lessonAdapter;

        public LessonViewHolder(@NonNull View itemView, LessonAdapter lessonAdapter) {
            super(itemView);
            holderView = itemView;
            lessonTitle = itemView.findViewById(R.id.lesson_title);
            lessonIcon = itemView.findViewById(R.id.lesson_icon);
//            playButton = itemView.findViewById(R.id.play_button);
//            replayButton = itemView.findViewById(R.id.replay_button);

            this.lessonAdapter = lessonAdapter;
        }
    }
}
