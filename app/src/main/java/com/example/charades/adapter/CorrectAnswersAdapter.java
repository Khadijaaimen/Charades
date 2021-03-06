package com.example.charades.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charades.R;

import java.util.ArrayList;

public class CorrectAnswersAdapter extends RecyclerView.Adapter<CorrectAnswersAdapter.CorrectHolderView> {

    ArrayList<String> correctList;
    Context context;

    public CorrectAnswersAdapter(ArrayList<String> correctList, Context context) {
        this.correctList = correctList;
        this.context = context;
    }


    @NonNull
    @Override
    public CorrectHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.correct_recyclerview, parent, false);
        return new CorrectAnswersAdapter.CorrectHolderView(rowItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CorrectHolderView holder, int position) {
        String count = String.valueOf(position+1);
        holder.correctText.setText(count + ". " + correctList.get(position));
    }


    @Override
    public int getItemCount() {
        return correctList.size();
    }

    public static class CorrectHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView correctText;

        public CorrectHolderView(@NonNull View itemView) {
            super(itemView);
            correctText = itemView.findViewById(R.id.correctNames);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
