package com.firdaus.example.ui.news;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import com.firdaus.example.model.news.Article;

import java.util.List;

public final class NewsAdapterBinder {

    private NewsAdapterBinder() {
        //NO-OP
    }

    @BindingAdapter("items")
    public static void bindItems(RecyclerView recyclerView, List<Article> items) {
        NewsAdapter adapter = new NewsAdapter();
        if (items != null) adapter.update(items);
    }
}