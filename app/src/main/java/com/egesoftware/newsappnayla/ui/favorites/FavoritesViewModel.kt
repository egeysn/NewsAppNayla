package com.egesoftware.newsappnayla.ui.favorites

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.egesoftware.newsappnayla.data.room.model.NewTableModel
import com.egesoftware.newsappnayla.data.room.repository.FavoriteNewsRepository


class FavoritesViewModel : ViewModel() {


    var favNewList: LiveData<List<NewTableModel>>? = null


    fun getFavoriteList(context: Context) : LiveData<List<NewTableModel>> {
        favNewList = FavoriteNewsRepository.getFavoriteNews(context)
        return favNewList as LiveData<List<NewTableModel>>
    }

}