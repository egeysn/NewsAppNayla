package com.egesoftware.newsappnayla.data.room.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.egesoftware.newsappnayla.data.room.FavoriteNewsDatabase
import com.egesoftware.newsappnayla.data.room.model.NewTableModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FavoriteNewsRepository {

    companion object {

        var database: FavoriteNewsDatabase? = null


        fun initializeDB(context: Context): FavoriteNewsDatabase {
            return FavoriteNewsDatabase.getDataseClient(context)
        }

        fun insertData(
            context: Context, title: String, category: String,
            description: String,
            img: String,
            date: String,
            webURL: String,
        ) {

            database = initializeDB(context)

            CoroutineScope(IO).launch {
                val details = NewTableModel(title,webURL,img,category,description,date )
                database!!.loginDao().InsertData(details)
            }

        }

        fun getFavoriteNews(context: Context): LiveData<List<NewTableModel>> {

            database = initializeDB(context)

           return database!!.loginDao().getAllFavList()


        }

    }
}