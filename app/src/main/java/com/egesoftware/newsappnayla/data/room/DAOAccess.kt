package com.egesoftware.newsappnayla.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.egesoftware.newsappnayla.data.room.model.NewTableModel


@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(newTableModel: NewTableModel)

    @Query("SELECT * FROM FavoriteNews ")
    fun getAllFavList() : LiveData<List<NewTableModel>>
}