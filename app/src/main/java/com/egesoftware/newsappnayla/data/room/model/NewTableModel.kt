package com.egesoftware.newsappnayla.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.egesoftware.newsappnayla.utils.Constant

@Entity(tableName = "FavoriteNews")
data class NewTableModel(
    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "webURL")
    var webURL:String,

    @ColumnInfo(name = "test")
    var test:String,

    @ColumnInfo(name = "category")
    var category:String,


    @ColumnInfo(name = "description")
    var description:String,

    @ColumnInfo(name = "date")
    var date:String)
{
    @PrimaryKey(autoGenerate = true)
    var newId: Int = 0
}

