package com.davidulloa.examendavidantonioulloarodriguez.binding;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingAdapters {
    @BindingAdapter("visibleGone")
    public static void showOrHide(View view, boolean show){
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("urlImageP")
    public static void setImage(ImageView imageView, String path){
        Glide.with(imageView.getContext())
                .load(path).into(imageView);
    }

    @BindingAdapter("urlImageUri")
    public static void setImage(ImageView imageView, Uri path){
        Glide.with(imageView.getContext())
                .load(path.toString()).into(imageView);
    }

}
