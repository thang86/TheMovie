package io.github.thang86.themovie.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.thang86.themovie.data.local.entity.DataRoom

/**
 *
 * Created by Thang86
 */
@Dao
interface QueriesDao {

    @Query("select * from user")
    fun getAll(): LiveData<List<DataRoom>>

    @Insert
    fun insertData(item: DataRoom)
}