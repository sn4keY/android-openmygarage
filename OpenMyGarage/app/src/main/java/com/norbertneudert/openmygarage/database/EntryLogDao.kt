package com.norbertneudert.openmygarage.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface EntryLogDao {
    @Query("SELECT * FROM entry_log_table ORDER BY entry_time DESC")
    fun getEntryLogs(): LiveData<List<EntryLog>>

    @Query("SELECT * FROM entry_log_table WHERE :dateFrom < entry_time < :dateUntil ORDER BY entry_time DESC")
    fun getEntryLogsBetween(dateFrom: Date, dateUntil: Date): LiveData<List<EntryLog>>

    @Insert
    fun insert(entryLog: EntryLog)

    @Query("DELETE FROM entry_log_table")
    fun clear()
}