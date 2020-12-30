package com.egesoftware.newsappnayla.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egesoftware.newsappnayla.data.api.ApiClient
import com.egesoftware.newsappnayla.data.models.NewsApiResponse
import com.egesoftware.newsappnayla.data.models.Result
import com.egesoftware.newsappnayla.data.repository.MainRepository
import com.egesoftware.newsappnayla.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : BaseViewModel() {

    val latestNewsLive = MutableLiveData<List<Result>>()
    val worldNewsLive = MutableLiveData<List<Result>>()



   fun fetchLatestNews(category:String) {
       dataLoading.value = true
       MainRepository.getInstance().getLatestNewsList(category = category) { isSuccess, response ->
           dataLoading.value = false
           if (isSuccess) {
               latestNewsLive.value = response?.response?.results
               empty.value = false
           } else {
               empty.value = true
           }
       }
    }

    fun fetchWorldNews() {
       dataLoading.value = true
        MainRepository.getInstance().getAroundWordNewsList() { isSuccess, response ->
           dataLoading.value = false
            if (isSuccess) {
                worldNewsLive.value = response?.response?.results
               empty.value = false
            } else {
                empty.value = true
            }
        }
    }

    fun allClicked(){
       //fetchLatestNews("all")
    }
    fun financeClicked(){
        //fetchLatestNews("finance")
    }
    fun sportClicked(){
        //fetchLatestNews("sport")
    }
    fun technologyClicked(){
        //fetchLatestNews("technology")
    }
}