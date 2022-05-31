package com.example.charades.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charades.activities.GameActivity;
import com.example.charades.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolderView> {

    ArrayList<String> categoryList;
    ArrayList<Integer> categoryIconsList;
    Context context;

    public CategoryAdapter(ArrayList<String> nameList, ArrayList<Integer> categoryIcons, Context context) {
        this.categoryList = nameList;
        this.categoryIconsList = categoryIcons;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recyclerview, parent, false);
        return new CategoryHolderView(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolderView holder, int position) {
        holder.categoryName.setText(categoryList.get(position));
        holder.categoryName.setVisibility(View.GONE);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GameActivity.class);
                intent.putExtra("category", categoryList.get(position));
                context.startActivity(intent);
            }
        });

        holder.categoryIcon.setImageResource(categoryIconsList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView categoryName;
        public ImageView categoryIcon;
        public LinearLayout linearLayout;

        public CategoryHolderView(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.name);
            categoryIcon = itemView.findViewById(R.id.icon);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }

        @Override
        public void onClick(View view) {
        }
    }
}
