package com.firdaus.example.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public final class ImageBinder {

    private ImageBinder() {
        //NO-OP
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
    }
}