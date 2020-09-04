package com.imaginatologintest.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.imaginatologintest.data.local.db.db_dao.LoginDao

@Database(entities = arrayOf(XaccData::class), version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract val loginDao: LoginDao
}