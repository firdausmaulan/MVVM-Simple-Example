package com.firdaus.example.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public final class ImageBinder {

    private ImageBinder() {
        //NO-OP
    }

    private static RequestOptions requestOptions = new RequestOptions().centerCrop();

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView).load(url).apply(requestOptions).into(imageView);
    }
}