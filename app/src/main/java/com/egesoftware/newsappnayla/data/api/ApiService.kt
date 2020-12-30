package com.egesoftware.newsappnayla.data.api

import com.egesoftware.newsappnayla.data.models.NewsApiResponse
import com.egesoftware.newsappnayla.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

/*    @GET("search/repositories")
    fun getRepo(@Query("q") search: String = "trending", @Query("sort") sort: String = "stars"): Call<GitResponse>*/

    @GET("search")
     fun getLatestNews(
        @Query(Constant.SECTION_PARAM) category: String?,
        @Query(Constant.PAGE_SIZE_PARAM) pageSize: String = "5",
        @Query(Constant.SHOW_FIELDS_PARAM) fields: String = Constant.SHOW_FIELDS,
        @Query(Constant.SHOW_TAGS_PARAM) showTagsParam:String = Constant.SHOW_TAGS,
        @Query(Constant.API_KEY_PARAM) apiKey: String = Constant.API_KEY,
    ): Call<NewsApiResponse>

    @GET("search")
    fun getAroundTheWorldNews(
        @Query(Constant.SECTION_PARAM) category: String = "world",
        @Query(Constant.PAGE_SIZE_PARAM) pageSize: String = "20",
        @Query(Constant.SHOW_FIELDS_PARAM) fields: String = Constant.SHOW_FIELDS,
        @Query(Constant.SHOW_TAGS_PARAM) showTagsParam:String = Constant.SHOW_TAGS,
        @Query(Constant.API_KEY_PARAM) apiKey: String = Constant.API_KEY,
    ): Call<NewsApiResponse>
}