package com.firdaus.example.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public final class BindingUtils {

    private BindingUtils() {
        //NO-OP
    }

    private static RequestOptions requestOptions = new RequestOptions().centerCrop();

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView).load(url).apply(requestOptions).into(imageView);
    }

    @BindingAdapter("setError")
    public static void setError(TextView textView, @StringRes Integer stringResourceId) {
        if (stringResourceId != null) {
            Context context = textView.getContext();
            textView.setError(context.getString(stringResourceId));
            textView.requestFocus();
        } else {
            textView.setError(null);
        }
    }

    /*@BindingAdapter("adapter")
    public static void setAdapter(RecyclerView view, Class adapter) {
        try {
            Object instance = adapter.newInstance();
            view.setAdapter((RecyclerView.Adapter) instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}