package com.firdaus.example.ui.news

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.firdaus.example.databinding.AdapterNewsBinding
import com.firdaus.example.model.news.Article


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val listArticle: MutableList<Article> = mutableListOf<Article>()

    fun update(list: List<Article>) {
        listArticle.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = AdapterNewsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }

    inner class ViewHolder(private val binding: AdapterNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listArticle[position]
        holder.bind(item)
    }

    /*override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
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
        fun bind(article: Article?) {
            binding.article = article
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (listArticle.size > 0) viewHolder.bind(listArticle[position])
    }*/

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun RecyclerView.bindItems(items: List<Article>?) {
            val adapter = adapter as NewsAdapter
            if (!items.isNullOrEmpty()) adapter.update(items)
        }
    }

    override fun getItemCount(): Int {
        return listArticle.size
    }
}