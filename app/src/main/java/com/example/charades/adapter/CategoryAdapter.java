package com.example.charades.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charades.activities.AppPreferences;
import com.example.charades.activities.CustomCategoryActivity;
import com.example.charades.activities.GameActivity;
import com.example.charades.R;
import com.example.charades.activities.InstructionsActivity;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolderView> {

    ArrayList<String> categoryList;
    ArrayList<Integer> categoryIconsList;
    Context context;
    ImageView pak, holly, bolly, play, close, icon, how, how2;
    Dialog dialog;
    ImageView btnClose;

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
    public void onBindViewHolder(@NonNull CategoryHolderView holder, @SuppressLint("RecyclerView") int position) {
        holder.categoryName.setText(categoryList.get(position));
        holder.categoryName.setVisibility(View.GONE);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (categoryList.get(position)) {
                    case "Celebrities":
                        showDialog("Celebrities");
                        break;
                    case "Movies":
                        showDialog("Movies");
                        pak.setVisibility(View.GONE);
                        break;
                    case "Songs":
                        showDialog("Songs");
                        pak.setVisibility(View.GONE);
                        break;
                    case "TV Shows":
                        showDialog("TV Shows");
                        bolly.setVisibility(View.GONE);
                        break;
                    case "Singers":
                        showDialog("Singers");
                        break;
                    case "Custom Category":
                        context.startActivity(new Intent(context, CustomCategoryActivity.class));
                        break;
                    default:
                        showIconDialog(position);
                        break;
                }
            }
        });

        int width = 440;
        int height = 460;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width,height);
        holder.categoryIcon.setLayoutParams(params);
        holder.categoryIcon.setImageResource(categoryIconsList.get(position));
    }

    private void showDialog(String category) {
        dialog = new Dialog(context, R.style.DialogStyle);
        dialog.setContentView(R.layout.custom_popmenu);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.white_bg);

        btnClose = dialog.findViewById(R.id.btn_close);
        pak = dialog.findViewById(R.id.pakiCeleb);
        holly = dialog.findViewById(R.id.hollyCeleb);
        bolly = dialog.findViewById(R.id.bollyCeleb);
        how2 = dialog.findViewById(R.id.btn_ok);

        how2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, InstructionsActivity.class));
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        pak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GameActivity.class);
                switch (category) {
                    case "Celebrities":
                        intent.putExtra("category", "Pakistani Celebrities");
                        break;
                    case "Singers":
                        intent.putExtra("category", "Pakistani Singers");
                        break;
                    case "TV Shows":
                        intent.putExtra("category", "Pakistani Dramas");
                        break;
                }
                context.startActivity(intent);
            }
        });

        holly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GameActivity.class);
                switch (category) {
                    case "Celebrities":
                        intent.putExtra("category", "Hollywood Celebrities");
                        break;
                    case "Movies":
                        intent.putExtra("category", "Hollywood Movies");
                        break;
                    case "Songs":
                        intent.putExtra("category", "English Songs");
                        break;
                    case "Singers":
                        intent.putExtra("category", "Hollywood Singers");
                        break;
                    case "TV Shows":
                        intent.putExtra("category", "Hollywood TV Shows");
                        break;
                }
                context.startActivity(intent);
            }
        });

        bolly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GameActivity.class);
                switch (category) {
                    case "Celebrities":
                        intent.putExtra("category", "Bollywood Celebrities");
                        break;
                    case "Movies":
                        intent.putExtra("category", "Bollywood Movies");
                        break;
                    case "Singers":
                        intent.putExtra("category", "Bollywood Singers");
                        break;
                    case "Songs":
                        intent.putExtra("category", "Hindi Songs");
                        break;
                }
                context.startActivity(intent);
            }
        });
        dialog.show();
    }

    private void showIconDialog(Integer position) {
        dialog = new Dialog(context, R.style.DialogStyle);
        dialog.setContentView(R.layout.custom_icon_popup);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        play = dialog.findViewById(R.id.playButton);
        close = dialog.findViewById(R.id.closeButton);
        icon = dialog.findViewById(R.id.icon);
        how = dialog.findViewById(R.id.howButton);

        how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, InstructionsActivity.class));
            }
        });

        icon.setImageResource(categoryIconsList.get(position));

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GameActivity.class);
                intent.putExtra("category", categoryList.get(position));
                context.startActivity(intent);
            }
        });

        dialog.show();
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
