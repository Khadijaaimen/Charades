package com.example.charades.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charades.activities.CustomCategoryActivity;
import com.example.charades.activities.GameActivity;
import com.example.charades.R;
import com.example.charades.activities.InstructionsActivity;
import com.example.charades.javaClass.AdPreferences;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolderView> {

    ArrayList<String> categoryList;
    ArrayList<Integer> categoryIconsList;
    Context context;
    ImageView pak, holly, bolly, play, close, icon, how, how2;
    Dialog dialog;
    ImageView btnClose;
    InterstitialAd mInterstitialAd;
    Integer isButtonClicked;

    public CategoryAdapter(ArrayList<String> nameList, ArrayList<Integer> categoryIcons, Context context) {
        this.categoryList = nameList;
        this.categoryIconsList = categoryIcons;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recyclerview, parent, false);
        CategoryHolderView holder = new CategoryHolderView(rowItem);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (categoryList.get(holder.getAdapterPosition())) {
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
                        showIconDialog(holder.getAdapterPosition());
                        break;
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolderView holder, @SuppressLint("RecyclerView") int position) {
        holder.categoryName.setText(categoryList.get(position));
//        Picasso.get().load(categoryIconsList.get(position)).into(holder.categoryIcon);
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

        isButtonClicked = AdPreferences.isButtonCLicked(context);

        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        if (isButtonClicked == 0) {
            setAds();
        }

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
                setAds();
                switch (category) {
                    case "Celebrities":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Pakistani Celebrities");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Pakistani Celebrities");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Pakistani Celebrities");
                            context.startActivity(intent);
                        }
                        break;
                    case "Singers":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Pakistani Singers");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Pakistani Singers");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Pakistani Singers");
                            context.startActivity(intent);
                        }
                        break;
                    case "TV Shows":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Pakistani Dramas");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Pakistani Dramas");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Pakistani Dramas");
                            context.startActivity(intent);
                        }
                        break;
                }
            }
        });

        holly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAds();
                switch (category) {
                    case "Celebrities":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood Celebrities");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood Celebrities");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Hollywood Celebrities");
                            context.startActivity(intent);
                        }
                        break;
                    case "Movies":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood Movies");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood Movies");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Hollywood Movies");
                            context.startActivity(intent);
                        }
                        break;
                    case "Songs":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "English Songs");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "English Songs");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "English Songs");
                            context.startActivity(intent);
                        }
                        break;
                    case "Singers":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood Singers");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood Singers");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Hollywood Singers");
                            context.startActivity(intent);
                        }
                        break;
                    case "TV Shows":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood TV Shows");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hollywood TV Shows");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Hollywood TV Shows");
                            context.startActivity(intent);
                        }
                        break;
                }
            }
        });

        bolly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAds();
                switch (category) {
                    case "Celebrities":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Bollywood Celebrities");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Bollywood Celebrities");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Bollywood Celebrities");
                            context.startActivity(intent);
                        }
                        break;
                    case "Movies":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Bollywood Movies");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Bollywood Movies");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Bollywood Movies");
                            context.startActivity(intent);
                        }
                        break;
                    case "Singers":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Bollywood Singers");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Bollywood Singers");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Bollywood Singers");
                            context.startActivity(intent);
                        }
                        break;
                    case "Songs":
                        if (isButtonClicked == 0) {
                            if (isNetworkAvailable(context)) {
                                if (mInterstitialAd != null) {
                                    isButtonClicked++;
                                    mInterstitialAd.show((Activity) context);
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hindi Songs");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }

                                        @Override
                                        public void onAdClicked() {
                                            super.onAdClicked();
                                            AdPreferences.setAdOpened(context, true);
                                            Intent intent = new Intent(context, GameActivity.class);
                                            intent.putExtra("category", "Hindi Songs");
                                            context.startActivity(intent);
                                            mInterstitialAd = null;
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                            }
                        } else if (isButtonClicked == 1) {
                            isButtonClicked--;
                            AdPreferences.setButtonCLicked(context, isButtonClicked);
                            Intent intent = new Intent(context, GameActivity.class);
                            intent.putExtra("category", "Hindi Songs");
                            context.startActivity(intent);
                        }
                        break;
                }
            }
        });
        dialog.show();
    }


    public Boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
        } else {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        }
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

        isButtonClicked = AdPreferences.isButtonCLicked(context);

        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        if (isButtonClicked == 0) {
            setAds();
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAds();
                if (isButtonClicked == 0) {
                    if (isNetworkAvailable(context)) {
                        if (mInterstitialAd != null) {
                            isButtonClicked++;
                            mInterstitialAd.show((Activity) context);
                            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    AdPreferences.setButtonCLicked(context, isButtonClicked);
                                    Intent intent = new Intent(context, GameActivity.class);
                                    intent.putExtra("category", categoryList.get(position));
                                    context.startActivity(intent);
                                    mInterstitialAd = null;
                                }

                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                    AdPreferences.setAdOpened(context, true);
                                    Intent intent = new Intent(context, GameActivity.class);
                                    intent.putExtra("category", categoryList.get(position));
                                    context.startActivity(intent);
                                    mInterstitialAd = null;
                                }
                            });
                        }
                    } else {
                        Toast.makeText(context.getApplicationContext(), "Please connect to Internet", Toast.LENGTH_SHORT).show();
                    }
                } else if (isButtonClicked == 1) {
                    isButtonClicked--;
                    AdPreferences.setButtonCLicked(context, isButtonClicked);
                    Intent intent = new Intent(context, GameActivity.class);
                    intent.putExtra("category", categoryList.get(position));
                    context.startActivity(intent);
                }
            }
        });
        dialog.show();
    }

    public void setAds() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(context, context.getString(R.string.adUnitID), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
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
