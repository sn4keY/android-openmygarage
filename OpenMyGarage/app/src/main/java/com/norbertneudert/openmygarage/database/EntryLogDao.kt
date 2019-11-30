package com.norbertneudert.openmygarage.database

import androidx.room.Dao
import androidx.room.Query
import java.util.*

@Dao
interface EntryLogDao {
    @Query("SELECT * FROM entry_log_table ORDER BY entry_time DESC")
    fun getEntryLogs(): List<EntryLog>

    @Query("SELECT * FROM entry_log_table WHERE :dateFrom < entry_time < :dateUntil ORDER BY entry_time DESC")
    fun getEntryLogsBetween(dateFrom: Date, dateUntil: Date): List<EntryLog>
}