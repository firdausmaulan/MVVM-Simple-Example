package com.firdaus.example.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.firdaus.example.R
import com.firdaus.example.databinding.AdapterNewsBinding
import com.firdaus.example.model.news.Article


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val listArticle: MutableList<Article> = mutableListOf<Article>()

    companion object {
        @BindingAdapter("newsItems")
        @JvmStatic
        fun RecyclerView.bindItems(items: List<Article>?) {
            val newsAdapter = adapter as NewsAdapter
            if (!items.isNullOrEmpty()) newsAdapter.update(items)
        }
    }

    fun update(list: List<Article>) {
        listArticle.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: AdapterNewsBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.adapter_news, parent, false
        )
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: AdapterNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listArticle[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listArticle.size
    }
}