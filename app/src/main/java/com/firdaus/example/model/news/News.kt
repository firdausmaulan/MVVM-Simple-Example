package com.firdaus.example.model.news

data class News(
        var status: String? = null,
        var articles: List<Article>? = emptyList(),
        var totalResults: Int? = null
)