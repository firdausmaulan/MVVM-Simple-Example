package com.firdaus.example.model.news

data class News(
        var articles: List<Article>,
        var status: String,
        var totalResults: Int
)