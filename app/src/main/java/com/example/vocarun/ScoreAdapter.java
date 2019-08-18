package com.example.vocarun;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {
    List<Score> scoreList;
    LayoutInflater layoutInflater;
    Activity activity;

    public ScoreAdapter(Context context, List<Score> scoreList) {
        layoutInflater = LayoutInflater.from(context);
        activity = (Activity)context;
        this.scoreList = scoreList;
        Log.d("size", String.valueOf(scoreList.size()));
    }

    @NonNull
    @Override
    public ScoreAdapter.ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ScoreView;

        ScoreView = layoutInflater.inflate(R.layout.score_box, parent, false);

        return new ScoreAdapter.ScoreViewHolder(ScoreView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreAdapter.ScoreViewHolder holder, final int position) {
        Score currentScore = scoreList.get(position);

        holder.scoreName.setText(currentScore.name);
        holder.scoreRank.setText(String.valueOf(position + 1));
        holder.scorePoint.setText(String.valueOf(currentScore.point));

        GradientDrawable drawable = (GradientDrawable)holder.scoreRank.getBackground();

        if (position == 0) {
            holder.scoreName.setTextColor(Color.RED);
            holder.scorePoint.setTextColor(Color.RED);
            holder.scoreRank.setTextColor(Color.RED);
            drawable.setStroke(3, Color.RED); // set stroke width and stroke color
        } else {
            if (position == 1) {
                holder.scoreName.setTextColor(Color.GREEN);
                holder.scorePoint.setTextColor(Color.GREEN);
                holder.scoreRank.setTextColor(Color.GREEN);
                drawable.setStroke(3, Color.GREEN); // set stroke width and stroke color
            } else {
                if (position == 2) {
                    holder.scoreName.setTextColor(Color.BLUE);
                    holder.scorePoint.setTextColor(Color.BLUE);
                    holder.scoreRank.setTextColor(Color.BLUE);
                    drawable.setStroke(3, Color.BLUE); // set stroke width and stroke color
                }
                else {
                    holder.scoreName.setTextColor(Color.BLACK);
                    holder.scorePoint.setTextColor(Color.BLACK);
                    holder.scoreRank.setTextColor(Color.BLACK);
                    drawable.setStroke(3, Color.BLACK); // set stroke width and stroke color
                }
            }
        }

//        holder.holderView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(activity, StudyLesson.class);
//                intent.putExtra("lesson", currentLesson.toString());
//                lessonList.get(position).isOld = true;
//                activity.startActivityForResult(intent, 11);
//                notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder {
        public View holderView;
        public TextView scoreRank;
        public TextView scoreName;
        public TextView scorePoint;
        ScoreAdapter scoreAdapter;

        public ScoreViewHolder(@NonNull View itemView, ScoreAdapter scoreAdapter) {
            super(itemView);
            holderView = itemView;
            scoreRank = itemView.findViewById(R.id.scoreRank);
            scoreName = itemView.findViewById(R.id.scoreName);
            scorePoint = itemView.findViewById(R.id.scorePoint);

            this.scoreAdapter = scoreAdapter;
        }
    }
}
