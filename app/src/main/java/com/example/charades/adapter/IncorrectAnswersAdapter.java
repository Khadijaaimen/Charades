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

public class IncorrectAnswersAdapter extends RecyclerView.Adapter<IncorrectAnswersAdapter.IncorrectHolderView>{

    ArrayList<String> incorrectList;
    Context context;

    public IncorrectAnswersAdapter(ArrayList<String> incorrectList, Context context) {
        this.incorrectList = incorrectList;
        this.context = context;
    }


    @NonNull
    @Override
    public IncorrectHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.incorrect_recyclerview, parent, false);
        return new IncorrectAnswersAdapter.IncorrectHolderView(rowItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull IncorrectHolderView holder, int position) {
        String count = String.valueOf(position+1);
        holder.incorrectText.setText(count + ". " + incorrectList.get(position));
    }

    @Override
    public int getItemCount() {
        return incorrectList.size();
    }

    public static class IncorrectHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView incorrectText;

        public IncorrectHolderView(@NonNull View itemView) {
            super(itemView);
            incorrectText = itemView.findViewById(R.id.incorrectNames);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
