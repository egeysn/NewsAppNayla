package com.egesoftware.newsappnayla.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egesoftware.newsappnayla.data.models.Result
import com.egesoftware.newsappnayla.databinding.CardItemAroundTheWorldBinding
import com.egesoftware.newsappnayla.ui.news.NewsViewModel
import timber.log.Timber

class NewsAroundTheWorldAdapter(private val newsViewModel:NewsViewModel) : RecyclerView.Adapter<NewsAroundTheWorldViewHolder>(){
     var newsAroundList: List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAroundTheWorldViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = CardItemAroundTheWorldBinding.inflate(inflater, parent, false)
        return NewsAroundTheWorldViewHolder(dataBinding, newsViewModel)

    }

    override fun getItemCount(): Int {
        Timber.e("newsAroundListSize:%s", newsAroundList.size)
        //Timber.i(newsAroundList.get(0).webTitle)
        return this.newsAroundList.size
    }


    override fun onBindViewHolder(viewHolder: NewsAroundTheWorldViewHolder, position: Int) {
        viewHolder.setup(newsAroundList[position])
    }


    fun updateNewsList(newsList: List<Result>) {
        this.newsAroundList = newsList
        notifyDataSetChanged()
    }


}
