package com.egesoftware.newsappnayla.data.repository

import com.egesoftware.newsappnayla.data.api.ApiClient
import com.egesoftware.newsappnayla.data.models.NewsApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository() {

    // GET repo list
    fun getAroundWordNewsList(onResult: (isSuccess: Boolean, response: NewsApiResponse?) -> Unit) {

        ApiClient.instance.getAroundTheWorldNews().enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(call: Call<NewsApiResponse>?, response: Response<NewsApiResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<NewsApiResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    fun getLatestNewsList(category:String, onResult: (isSuccess: Boolean, response: NewsApiResponse?) -> Unit) {

        ApiClient.instance.getLatestNews(category = category).enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(
                call: Call<NewsApiResponse>?,
                response: Response<NewsApiResponse>?
            ) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<NewsApiResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }



    companion object {
        private var INSTANCE: MainRepository? = null
        fun getInstance() = INSTANCE
            ?: MainRepository().also {
                INSTANCE = it
            }
    }
}