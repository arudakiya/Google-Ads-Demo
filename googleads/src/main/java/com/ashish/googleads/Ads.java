package com.ashish.googleads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Date;


public class Ads {
    public static boolean interstitialsAdsFLAG = true;
    public static boolean appOpenAdsFLAG = true;
    public static boolean rewordAdsFLAG = true;
    public static boolean getRewordFLAG = false;

    public static String AdsTAG = "Google Ads -->> ";

    public static void setAdsUnits(@NonNull Context activity, String banner, String full, String native_advance, String app_open, String reword) {
        SharedPreferences.Editor editor = activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).edit();
        editor.putString("banner", banner);
        editor.putString("full", full);
        editor.putString("native_advance", native_advance);
        editor.putString("app_open", app_open);
        editor.putString("reword", reword);
        editor.commit();
    }

    public static void bannerAdLoadGoogle(Activity context, final LinearLayout linearLayout) {
        AdView mAdView = new AdView(context);
        if (isNetworkAvailable(context)) {
            mAdView.setVisibility(View.VISIBLE);
            mAdView.setEnabled(true);
            mAdView.setAdSize(AdSize.BANNER);
            mAdView.setAdUnitId(context.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("banner", ""));
            try {
                linearLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d(AdsTAG, "Banner " + loadAdError.getMessage());
                    try {
                        linearLayout.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mAdView.loadAd(new AdRequest.Builder().build());
            linearLayout.removeAllViews();
            linearLayout.addView(mAdView);
        } else {
            try {
                linearLayout.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                linearLayout.removeAllViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void bannerAdLoadGoogle(Activity context, final LinearLayout linearLayout,String adsUnit) {
        AdView mAdView = new AdView(context);
        if (isNetworkAvailable(context)) {
            mAdView.setVisibility(View.VISIBLE);
            mAdView.setEnabled(true);
            mAdView.setAdSize(AdSize.BANNER);
            mAdView.setAdUnitId(adsUnit);
            try {
                linearLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d(AdsTAG, "Banner " + loadAdError.getMessage());
                    try {
                        linearLayout.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mAdView.loadAd(new AdRequest.Builder().build());
            linearLayout.removeAllViews();
            linearLayout.addView(mAdView);
        } else {
            try {
                linearLayout.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                linearLayout.removeAllViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void bannerAdLoadGoogle(Activity context, AdSize adSize, final LinearLayout linearLayout) {
        AdView mAdView = new AdView(context);
        if (isNetworkAvailable(context)) {
            mAdView.setVisibility(View.VISIBLE);
            mAdView.setEnabled(true);
            mAdView.setAdSize(adSize);
            mAdView.setAdUnitId(context.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("banner", ""));
            try {
                linearLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d(AdsTAG, "Banner " + loadAdError.getMessage());
                    try {
                        linearLayout.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mAdView.loadAd(new AdRequest.Builder().build());
            linearLayout.removeAllViews();
            linearLayout.addView(mAdView);
        } else {
            try {
                linearLayout.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                linearLayout.removeAllViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void bannerAdLoadGoogle(Activity context, AdSize adSize, final LinearLayout linearLayout,String adsUnit) {
        AdView mAdView = new AdView(context);
        if (isNetworkAvailable(context)) {
            mAdView.setVisibility(View.VISIBLE);
            mAdView.setEnabled(true);
            mAdView.setAdSize(adSize);
            mAdView.setAdUnitId(adsUnit);
            try {
                linearLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d(AdsTAG, "Banner " + loadAdError.getMessage());
                    try {
                        linearLayout.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mAdView.loadAd(new AdRequest.Builder().build());
            linearLayout.removeAllViews();
            linearLayout.addView(mAdView);
        } else {
            try {
                linearLayout.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                linearLayout.removeAllViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void adaptiveBannerAdLoadGoogle(Activity context, int bannerWidth, final LinearLayout linearLayout) {
        AdView mAdView = new AdView(context);
        if (isNetworkAvailable(context)) {
            mAdView.setVisibility(View.VISIBLE);
            mAdView.setEnabled(true);
            mAdView.setAdSize(AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(context, bannerWidth));
            mAdView.setAdUnitId(context.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("banner", ""));
            try {
                linearLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d(AdsTAG, "Banner " + loadAdError.getMessage());
                    try {
                        linearLayout.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mAdView.loadAd(new AdRequest.Builder().build());
            linearLayout.removeAllViews();
            linearLayout.addView(mAdView);
        } else {
            try {
                linearLayout.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                linearLayout.removeAllViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void adaptiveBannerAdLoadGoogle(Activity context, int bannerWidth, final LinearLayout linearLayout,String adsUnit) {
        AdView mAdView = new AdView(context);
        if (isNetworkAvailable(context)) {
            mAdView.setVisibility(View.VISIBLE);
            mAdView.setEnabled(true);
            mAdView.setAdSize(AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(context, bannerWidth));
            mAdView.setAdUnitId(adsUnit);
            try {
                linearLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d(AdsTAG, "Banner " + loadAdError.getMessage());
                    try {
                        linearLayout.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mAdView.loadAd(new AdRequest.Builder().build());
            linearLayout.removeAllViews();
            linearLayout.addView(mAdView);
        } else {
            try {
                linearLayout.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                linearLayout.removeAllViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showFullScreenAds(Activity activity, Intent intent, boolean isCloseActivity) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("full", ""), adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                interstitialsAdsFLAG = true;
                                activity.startActivity(intent);
                                if (isCloseActivity) {
                                    activity.finish();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, Intent intent, boolean isCloseActivity,String adsUnit) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, adsUnit, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                interstitialsAdsFLAG = true;
                                activity.startActivity(intent);
                                if (isCloseActivity) {
                                    activity.finish();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, OnShowAdCompleteListener onShowAdCompleteListener) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("full", ""), adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            onShowAdCompleteListener.onShowAdComplete();
                            try {
                                interstitialsAdsFLAG = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, OnShowAdCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity,adsUnit, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            onShowAdCompleteListener.onShowAdComplete();
                            try {
                                interstitialsAdsFLAG = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, Intent intent, Dialog dialog, boolean isCloseActivity) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("full", ""), adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                interstitialsAdsFLAG = true;
                                activity.startActivity(intent);
                                if (isCloseActivity) {
                                    activity.finish();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, Intent intent, Dialog dialog, boolean isCloseActivity,String adsUnit) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, adsUnit, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                        activity.startActivity(intent);
                                        if (isCloseActivity) {
                                            activity.finish();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                interstitialsAdsFLAG = true;
                                activity.startActivity(intent);
                                if (isCloseActivity) {
                                    activity.finish();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, Dialog dialog, OnShowAdCompleteListener onShowAdCompleteListener) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("full", ""), adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            onShowAdCompleteListener.onShowAdComplete();
                            try {
                                interstitialsAdsFLAG = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, Dialog dialog, OnShowAdCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, adsUnit, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                    try {
                                        interstitialsAdsFLAG = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            interstitialAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            onShowAdCompleteListener.onShowAdComplete();
                            try {
                                interstitialsAdsFLAG = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            new Handler().postDelayed(() -> {
                if (dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);
        }
    }

    public static void showFullScreenAds(Activity activity, Intent intent, int R_layout_dialog_loading, boolean isCloseActivity) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();
                AdRequest adRequest = new AdRequest.Builder().build();
                InterstitialAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("full", ""), adRequest,
                        new InterstitialAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdClicked() {
                                        super.onAdClicked();
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                        try {
                                            interstitialsAdsFLAG = true;
                                            activity.startActivity(intent);
                                            if (isCloseActivity) {
                                                activity.finish();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                        try {
                                            interstitialsAdsFLAG = true;
                                            activity.startActivity(intent);
                                            if (isCloseActivity) {
                                                activity.finish();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                interstitialAd.show(activity);
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                try {
                                    interstitialsAdsFLAG = true;
                                    activity.startActivity(intent);
                                    if (isCloseActivity) {
                                        activity.finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                new Handler().postDelayed(() -> {
                    if (dialog.isShowing()) {
                        try {
                            dialog.dismiss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 4000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showFullScreenAds(Activity activity, Intent intent, int R_layout_dialog_loading, boolean isCloseActivity,String adsUnit) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();
                AdRequest adRequest = new AdRequest.Builder().build();
                InterstitialAd.load(activity, adsUnit, adRequest,
                        new InterstitialAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdClicked() {
                                        super.onAdClicked();
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                        try {
                                            interstitialsAdsFLAG = true;
                                            activity.startActivity(intent);
                                            if (isCloseActivity) {
                                                activity.finish();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                        try {
                                            interstitialsAdsFLAG = true;
                                            activity.startActivity(intent);
                                            if (isCloseActivity) {
                                                activity.finish();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                interstitialAd.show(activity);
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                try {
                                    interstitialsAdsFLAG = true;
                                    activity.startActivity(intent);
                                    if (isCloseActivity) {
                                        activity.finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                new Handler().postDelayed(() -> {
                    if (dialog.isShowing()) {
                        try {
                            dialog.dismiss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 4000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showFullScreenAds(Activity activity, int R_layout_dialog_loading, OnShowAdCompleteListener onShowAdCompleteListener) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();
                AdRequest adRequest = new AdRequest.Builder().build();
                InterstitialAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("full", ""), adRequest,
                        new InterstitialAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdClicked() {
                                        super.onAdClicked();
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                        try {
                                            interstitialsAdsFLAG = true;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                        try {
                                            interstitialsAdsFLAG = true;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }
                                });
                                interstitialAd.show(activity);
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                onShowAdCompleteListener.onShowAdComplete();
                                try {
                                    interstitialsAdsFLAG = true;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                new Handler().postDelayed(() -> {
                    if (dialog.isShowing()) {
                        try {
                            dialog.dismiss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 4000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showFullScreenAds(Activity activity, int R_layout_dialog_loading, OnShowAdCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (interstitialsAdsFLAG) {
            interstitialsAdsFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();
                AdRequest adRequest = new AdRequest.Builder().build();
                InterstitialAd.load(activity, adsUnit, adRequest,
                        new InterstitialAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                Log.d(AdsTAG, "InterstitialAd onAdLoaded");
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdClicked() {
                                        super.onAdClicked();
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        Log.d(AdsTAG, "InterstitialAd onAdDismissedFullScreenContent");
                                        try {
                                            interstitialsAdsFLAG = true;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        Log.d(AdsTAG, "InterstitialAd " + adError.getMessage());
                                        try {
                                            interstitialsAdsFLAG = true;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }
                                });
                                interstitialAd.show(activity);
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "InterstitialAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                onShowAdCompleteListener.onShowAdComplete();
                                try {
                                    interstitialsAdsFLAG = true;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                new Handler().postDelayed(() -> {
                    if (dialog.isShowing()) {
                        try {
                            dialog.dismiss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 4000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showGoogleNativeAds(final Activity activity, @NonNull final RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(View.VISIBLE);
        AdLoader adLoader = new AdLoader.Builder(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("native_advance", ""))
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        Log.d(AdsTAG, "NativeAd onNativeAdLoaded");
                        NativeAdView unifiedNativeAdView;
                        try {
                            unifiedNativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.native_ad, null);
                            unifiedNativeAdView.isHardwareAccelerated();
                            populateUnifiedNativeAdView(nativeAd, unifiedNativeAdView);
                            relativeLayout.removeAllViews();
                            relativeLayout.addView(unifiedNativeAdView);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }

                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        Log.d(AdsTAG, "NativeAd " + adError.getMessage());
                        try {
                            relativeLayout.setVisibility(View.GONE);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public static void showGoogleNativeAds(final Activity activity, @NonNull final RelativeLayout relativeLayout, String adsUnit) {
        relativeLayout.setVisibility(View.VISIBLE);
        AdLoader adLoader = new AdLoader.Builder(activity, adsUnit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        Log.d(AdsTAG, "NativeAd onNativeAdLoaded");
                        NativeAdView unifiedNativeAdView;
                        try {
                            unifiedNativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.native_ad, null);
                            unifiedNativeAdView.isHardwareAccelerated();
                            populateUnifiedNativeAdView(nativeAd, unifiedNativeAdView);
                            relativeLayout.removeAllViews();
                            relativeLayout.addView(unifiedNativeAdView);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }

                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        Log.d(AdsTAG, "NativeAd " + adError.getMessage());
                        try {
                            relativeLayout.setVisibility(View.GONE);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public static NativeAd getGoogleNativeAds(final Activity activity) {
        final boolean[] nativeLoadFLAG = {true};
        final NativeAd[] nativeAdVar = {null};
        AdLoader adLoader = new AdLoader.Builder(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("native_advance", ""))
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        Log.d(AdsTAG, "NativeAd onNativeAdLoaded");
                        nativeAdVar[0] = nativeAd;

                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        Log.d(AdsTAG, "NativeAd " + adError.getMessage());
                    }
                }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nativeLoadFLAG[0] =false;
            }
        }, 4000);
        if ((nativeAdVar == null) || (nativeAdVar[0] == null)) {
            do {
                try {
                    if (nativeAdVar[0] != null) {
                        return nativeAdVar[0];
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (nativeLoadFLAG[0]);
        }
        return nativeAdVar[0];
    }

    public static NativeAd getGoogleNativeAds(final Activity activity,String adsUnit) {
        final boolean[] nativeLoadFLAG = {true};
        final NativeAd[] nativeAdVar = {null};
        AdLoader adLoader = new AdLoader.Builder(activity, adsUnit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        Log.d(AdsTAG, "NativeAd onNativeAdLoaded");
                        nativeAdVar[0] = nativeAd;

                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        Log.d(AdsTAG, "NativeAd " + adError.getMessage());
                    }
                }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nativeLoadFLAG[0] =false;
            }
        }, 4000);
        if ((nativeAdVar == null) || (nativeAdVar[0] == null)) {
            do {
                try {
                    if (nativeAdVar[0] != null) {
                        return nativeAdVar[0];
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (nativeLoadFLAG[0]);
        }
        return nativeAdVar[0];
    }

    public static void showGoogleNativeAds(final Activity activity, int R_layout_native, @NonNull final RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(View.VISIBLE);
        AdLoader adLoader = new AdLoader.Builder(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("native_advance", ""))
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        Log.d(AdsTAG, "NativeAd onNativeAdLoaded");
                        NativeAdView unifiedNativeAdView;
                        try {
                            unifiedNativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R_layout_native, null);
                            unifiedNativeAdView.isHardwareAccelerated();
                            populateUnifiedNativeAdView(nativeAd, unifiedNativeAdView);
                            relativeLayout.removeAllViews();
                            relativeLayout.addView(unifiedNativeAdView);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }

                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        Log.d(AdsTAG, "NativeAd " + adError.getMessage());
                        try {
                            relativeLayout.setVisibility(View.GONE);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public static void showGoogleNativeAds(final Activity activity, int R_layout_native, @NonNull final RelativeLayout relativeLayout, String adsUnit) {
        relativeLayout.setVisibility(View.VISIBLE);
        AdLoader adLoader = new AdLoader.Builder(activity, adsUnit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        Log.d(AdsTAG, "NativeAd onNativeAdLoaded");
                        NativeAdView unifiedNativeAdView;
                        try {
                            unifiedNativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R_layout_native, null);
                            unifiedNativeAdView.isHardwareAccelerated();
                            populateUnifiedNativeAdView(nativeAd, unifiedNativeAdView);
                            relativeLayout.removeAllViews();
                            relativeLayout.addView(unifiedNativeAdView);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }

                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        Log.d(AdsTAG, "NativeAd " + adError.getMessage());
                        try {
                            relativeLayout.setVisibility(View.GONE);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public static void showAppOpenAds(final Activity activity, OnShowAdCompleteListener onShowAdCompleteListener) {
        if (appOpenAdsFLAG) {
            appOpenAdsFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();
            AdRequest request = new AdRequest.Builder().build();
            AppOpenAd.load(activity,
                    activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("app_open", ""),
                    request,
                    AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                    new AppOpenAd.AppOpenAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            Log.d(AdsTAG, "AppOpenAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    Log.d(AdsTAG, "AppOpenAd onAdDismissedFullScreenContent");
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    Log.d(AdsTAG, "AppOpenAd " + adError.getMessage());
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            appOpenAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "AppOpenAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete();
                        }
                    });
        }


    }

    public static void showAppOpenAds(final Activity activity, OnShowAdCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (appOpenAdsFLAG) {
            appOpenAdsFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();
            AdRequest request = new AdRequest.Builder().build();
            AppOpenAd.load(activity,
                    adsUnit,
                    request,
                    AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                    new AppOpenAd.AppOpenAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            Log.d(AdsTAG, "AppOpenAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    Log.d(AdsTAG, "AppOpenAd onAdDismissedFullScreenContent");
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    Log.d(AdsTAG, "AppOpenAd " + adError.getMessage());
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            appOpenAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "AppOpenAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete();
                        }
                    });
        }


    }

    public static void showAppOpenAds(final Activity activity, Dialog dialog, OnShowAdCompleteListener onShowAdCompleteListener) {
        if (appOpenAdsFLAG) {
            appOpenAdsFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest request = new AdRequest.Builder().build();
            AppOpenAd.load(activity,
                    activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("app_open", ""),
                    request,
                    AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                    new AppOpenAd.AppOpenAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            Log.d(AdsTAG, "AppOpenAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    Log.d(AdsTAG, "AppOpenAd onAdDismissedFullScreenContent");
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    Log.d(AdsTAG, "AppOpenAd " + adError.getMessage());
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            appOpenAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "AppOpenAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete();
                        }
                    });
        }


    }

    public static void showAppOpenAds(final Activity activity, Dialog dialog, OnShowAdCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (appOpenAdsFLAG) {
            appOpenAdsFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest request = new AdRequest.Builder().build();
            AppOpenAd.load(activity,
                    adsUnit,
                    request,
                    AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                    new AppOpenAd.AppOpenAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            Log.d(AdsTAG, "AppOpenAd onAdLoaded");
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    Log.d(AdsTAG, "AppOpenAd onAdDismissedFullScreenContent");
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                    Log.d(AdsTAG, "AppOpenAd " + adError.getMessage());
                                    appOpenAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete();
                                }
                            });
                            appOpenAd.show(activity);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "AppOpenAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            appOpenAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete();
                        }
                    });
        }


    }

    public static void showAppOpenAds(final Activity activity, int R_layout_dialog_loading, OnShowAdCompleteListener onShowAdCompleteListener) {
        if (appOpenAdsFLAG) {
            appOpenAdsFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();
                AdRequest request = new AdRequest.Builder().build();
                AppOpenAd.load(activity,
                        activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("app_open", ""),
                        request,
                        AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                        new AppOpenAd.AppOpenAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                                Log.d(AdsTAG, "AppOpenAd onAdLoaded");
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        Log.d(AdsTAG, "AppOpenAd onAdDismissedFullScreenContent");
                                        appOpenAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        Log.d(AdsTAG, "AppOpenAd " + adError.getMessage());
                                        appOpenAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }
                                });
                                appOpenAd.show(activity);
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "AppOpenAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                appOpenAdsFLAG = true;
                                onShowAdCompleteListener.onShowAdComplete();
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static void showAppOpenAds(final Activity activity, int R_layout_dialog_loading, OnShowAdCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (appOpenAdsFLAG) {
            appOpenAdsFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();
                AdRequest request = new AdRequest.Builder().build();
                AppOpenAd.load(activity,
                        adsUnit,
                        request,
                        AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                        new AppOpenAd.AppOpenAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                                Log.d(AdsTAG, "AppOpenAd onAdLoaded");
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        Log.d(AdsTAG, "AppOpenAd onAdDismissedFullScreenContent");
                                        appOpenAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        Log.d(AdsTAG, "AppOpenAd " + adError.getMessage());
                                        appOpenAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete();
                                    }
                                });
                                appOpenAd.show(activity);
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "AppOpenAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                appOpenAdsFLAG = true;
                                onShowAdCompleteListener.onShowAdComplete();
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static void showRewordAds(final Activity activity, OnShowRewordCompleteListener onShowAdCompleteListener) {
        if (rewordAdsFLAG) {
            rewordAdsFLAG = false;
            getRewordFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();

            AdRequest adRequest = new AdRequest.Builder().build();
            RewardedAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("reword", ""),
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "RewardedAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            rewordAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            Log.d(AdsTAG, "RewardedAd onAdLoaded");
                            rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "RewardedAd onAdDismissedFullScreenContent");
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                    Log.d(AdsTAG, "RewardedAd " + adError.getMessage());
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdImpression() {
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                            rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Log.d(AdsTAG, "RewardedAd onUserEarnedReward");
                                    getRewordFLAG = true;
                                }
                            });
                        }
                    });
        }
    }

    public static void showRewordAds(final Activity activity, OnShowRewordCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (rewordAdsFLAG) {
            rewordAdsFLAG = false;
            getRewordFLAG = false;
            Dialog dialog = new Dialog(activity);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.show();

            AdRequest adRequest = new AdRequest.Builder().build();
            RewardedAd.load(activity, adsUnit,
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "RewardedAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            rewordAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            Log.d(AdsTAG, "RewardedAd onAdLoaded");
                            rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "RewardedAd onAdDismissedFullScreenContent");
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                    Log.d(AdsTAG, "RewardedAd " + adError.getMessage());
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdImpression() {
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                            rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Log.d(AdsTAG, "RewardedAd onUserEarnedReward");
                                    getRewordFLAG = true;
                                }
                            });
                        }
                    });
        }
    }

    public static void showRewordAds(final Activity activity, Dialog dialog, OnShowRewordCompleteListener onShowAdCompleteListener) {
        if (rewordAdsFLAG) {
            rewordAdsFLAG = false;
            getRewordFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            RewardedAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("reword", ""),
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "RewardedAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            rewordAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            Log.d(AdsTAG, "RewardedAd onAdLoaded");
                            rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "RewardedAd onAdDismissedFullScreenContent");
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                    Log.d(AdsTAG, "RewardedAd " + adError.getMessage());
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdImpression() {
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                            rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Log.d(AdsTAG, "RewardedAd onUserEarnedReward");
                                    getRewordFLAG = true;
                                }
                            });
                        }
                    });
        }
    }

    public static void showRewordAds(final Activity activity, Dialog dialog, OnShowRewordCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (rewordAdsFLAG) {
            rewordAdsFLAG = false;
            getRewordFLAG = false;
            dialog.setCancelable(false);
            dialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            RewardedAd.load(activity,adsUnit,
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d(AdsTAG, "RewardedAd " + loadAdError.getMessage());
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            rewordAdsFLAG = true;
                            onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            Log.d(AdsTAG, "RewardedAd onAdLoaded");
                            rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d(AdsTAG, "RewardedAd onAdDismissedFullScreenContent");
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                    Log.d(AdsTAG, "RewardedAd " + adError.getMessage());
                                    try {
                                        dialog.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    rewordAdsFLAG = true;
                                    onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                }

                                @Override
                                public void onAdImpression() {
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                            rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Log.d(AdsTAG, "RewardedAd onUserEarnedReward");
                                    getRewordFLAG = true;
                                }
                            });
                        }
                    });
        }
    }

    public static void showRewordAds(final Activity activity, int R_layout_dialog_loading, OnShowRewordCompleteListener onShowAdCompleteListener) {
        if (rewordAdsFLAG) {
            rewordAdsFLAG = false;
            getRewordFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();

                AdRequest adRequest = new AdRequest.Builder().build();
                RewardedAd.load(activity, activity.getSharedPreferences("GoogleAds", Context.MODE_PRIVATE).getString("reword", ""),
                        adRequest, new RewardedAdLoadCallback() {
                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "RewardedAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                rewordAdsFLAG = true;
                                onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                            }

                            @Override
                            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                Log.d(AdsTAG, "RewardedAd onAdLoaded");
                                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdClicked() {
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        Log.d(AdsTAG, "RewardedAd onAdDismissedFullScreenContent");
                                        try {
                                            dialog.dismiss();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        rewordAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        Log.d(AdsTAG, "RewardedAd " + adError.getMessage());
                                        try {
                                            dialog.dismiss();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        rewordAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                    }

                                    @Override
                                    public void onAdImpression() {
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                    }
                                });
                                rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                                    @Override
                                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                        Log.d(AdsTAG, "RewardedAd onUserEarnedReward");
                                        getRewordFLAG = true;
                                    }
                                });
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showRewordAds(final Activity activity, int R_layout_dialog_loading, OnShowRewordCompleteListener onShowAdCompleteListener,String adsUnit) {
        if (rewordAdsFLAG) {
            rewordAdsFLAG = false;
            getRewordFLAG = false;
            try {
                Dialog dialog = new Dialog(activity);
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setCancelable(false);
                dialog.setContentView(R_layout_dialog_loading);
                dialog.show();

                AdRequest adRequest = new AdRequest.Builder().build();
                RewardedAd.load(activity,adsUnit,
                        adRequest, new RewardedAdLoadCallback() {
                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.d(AdsTAG, "RewardedAd " + loadAdError.getMessage());
                                try {
                                    dialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                rewordAdsFLAG = true;
                                onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                            }

                            @Override
                            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                Log.d(AdsTAG, "RewardedAd onAdLoaded");
                                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdClicked() {
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        Log.d(AdsTAG, "RewardedAd onAdDismissedFullScreenContent");
                                        try {
                                            dialog.dismiss();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        rewordAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        Log.d(AdsTAG, "RewardedAd " + adError.getMessage());
                                        try {
                                            dialog.dismiss();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        rewordAdsFLAG = true;
                                        onShowAdCompleteListener.onShowAdComplete(getRewordFLAG);
                                    }

                                    @Override
                                    public void onAdImpression() {
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                    }
                                });
                                rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                                    @Override
                                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                        Log.d(AdsTAG, "RewardedAd onUserEarnedReward");
                                        getRewordFLAG = true;
                                    }
                                });
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void populateUnifiedNativeAdView(NativeAd unifiedNativeAd, NativeAdView unifiedNativeAdView) {
        try {
            unifiedNativeAdView.setMediaView((MediaView) unifiedNativeAdView.findViewById(R.id.ad_media));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.ad_headline));
        } catch (Exception e) {
            e.printStackTrace();
        }
      /*try {
            unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.ad_body));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.ad_app_icon));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            unifiedNativeAdView.setPriceView(unifiedNativeAdView.findViewById(R.id.ad_price));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            unifiedNativeAdView.setStarRatingView(unifiedNativeAdView.findViewById(R.id.ad_stars));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            unifiedNativeAdView.setStoreView(unifiedNativeAdView.findViewById(R.id.ad_store));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            unifiedNativeAdView.setAdvertiserView(unifiedNativeAdView.findViewById(R.id.ad_advertiser));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (unifiedNativeAd.getBody() == null) {
            try {
                unifiedNativeAdView.getBodyView().setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                unifiedNativeAdView.getBodyView().setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
           /* try {
                ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        if (unifiedNativeAd.getCallToAction() == null) {
            try {
                unifiedNativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                unifiedNativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ((Button) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (unifiedNativeAd.getIcon() == null) {
            try {
                unifiedNativeAdView.getIconView().setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                unifiedNativeAdView.getIconView().setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (unifiedNativeAd.getPrice() == null) {
            try {
                unifiedNativeAdView.getPriceView().setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                unifiedNativeAdView.getPriceView().setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ((TextView) unifiedNativeAdView.getPriceView()).setText(unifiedNativeAd.getPrice());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (unifiedNativeAd.getStore() == null) {
            try {
                unifiedNativeAdView.getStoreView().setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                unifiedNativeAdView.getStoreView().setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ((TextView) unifiedNativeAdView.getStoreView()).setText(unifiedNativeAd.getStore());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (unifiedNativeAd.getStarRating() == null) {
            try {
                unifiedNativeAdView.getStarRatingView().setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ((RatingBar) unifiedNativeAdView.getStarRatingView()).setRating(unifiedNativeAd.getStarRating().floatValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                unifiedNativeAdView.getStarRatingView().setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (unifiedNativeAd.getAdvertiser() == null) {
            try {
                unifiedNativeAdView.getAdvertiserView().setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ((TextView) unifiedNativeAdView.getAdvertiserView()).setText(unifiedNativeAd.getAdvertiser());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                unifiedNativeAdView.getAdvertiserView().setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNetworkAvailable(@NonNull Activity activity) {
        ConnectivityManager manager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public interface OnShowAdCompleteListener {
        void onShowAdComplete();
    }

    public interface OnShowRewordCompleteListener {
        void onShowAdComplete(boolean isRewordGet);
    }

}
