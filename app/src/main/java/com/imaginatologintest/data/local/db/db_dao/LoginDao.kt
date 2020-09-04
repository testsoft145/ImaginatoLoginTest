package com.imaginatologintest.data.local.db.db_dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.imaginatologintest.data.local.db.XaccData

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertXaccData(xaccData: XaccData): Long

}