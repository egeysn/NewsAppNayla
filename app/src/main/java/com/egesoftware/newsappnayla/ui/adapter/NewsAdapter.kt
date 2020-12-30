package com.egesoftware.newsappnayla.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egesoftware.newsappnayla.data.models.Result
import com.egesoftware.newsappnayla.databinding.CardLatestNewItemBinding

import com.egesoftware.newsappnayla.ui.news.NewsViewModel

class NewsAdapter(private val newsViewModel: NewsViewModel) :
    RecyclerView.Adapter<NewsViewHolder>() {
    //var repoList: List<Item> = emptyList()
    var latestNewsList: List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = CardLatestNewItemBinding.inflate(inflater, parent, false)

         ViewGroup.LayoutParams((parent.width * 0.8).toInt(),ViewGroup.LayoutParams.MATCH_PARENT)

        return NewsViewHolder(dataBinding, newsViewModel)

    }

    override fun getItemCount() = latestNewsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.setup(latestNewsList[position])
    }

    fun updateNewsList(newsList: List<Result>){
        this.latestNewsList = newsList
        notifyDataSetChanged()
    }
   /* fun updateRepoList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }*/

}