package com.egesoftware.newsappnayla.data.models

data class Tag(
    val apiUrl: String,
    val bio: String,
    val bylineImageUrl: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val references: List<Any>,
    val twitterHandle: String,
    val type: String,
    val webTitle: String,
    val webUrl: String
)