package com.egesoftware.newsappnayla.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.egesoftware.newsappnayla.data.room.model.NewTableModel


@Database(entities = arrayOf(NewTableModel::class), version = 1, exportSchema = false)
abstract class FavoriteNewsDatabase :RoomDatabase(){

    abstract fun loginDao() : DAOAccess
    companion object {

        @Volatile
        private var INSTANCE: FavoriteNewsDatabase? = null

        fun getDataseClient(context: Context) : FavoriteNewsDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, FavoriteNewsDatabase::class.java, "news_database")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }
}