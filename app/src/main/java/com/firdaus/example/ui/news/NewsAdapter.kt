package com.firdaus.example.ui.news

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.firdaus.example.R
import com.firdaus.example.databinding.AdapterNewsBinding
import com.firdaus.example.model.news.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val listArticle = mutableListOf<Article>()

    fun update(list: List<Article>) {
        listArticle.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        return ViewHolder(viewGroup)
    }

    class ViewHolder(
            private val parent: ViewGroup,
            private val binding: AdapterNewsBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.adapter_news,
                    parent,
                    false
            )
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("NewsAdapter", "onBindViewHolder")
        viewHolder.bind(listArticle[position])
    }

    override fun getItemCount() = listArticle.size
}