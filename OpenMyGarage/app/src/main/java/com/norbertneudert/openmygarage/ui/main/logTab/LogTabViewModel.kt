package com.norbertneudert.openmygarage.ui.main.logTab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.norbertneudert.openmygarage.database.EntryLog
import com.norbertneudert.openmygarage.database.EntryLogDao
import kotlinx.coroutines.*

class LogTabViewModel(val database: EntryLogDao, application: Application) : AndroidViewModel(application) {
    val logs = database.getEntryLogs()

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onClear(){
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear() {
       withContext(Dispatchers.IO) {
           database.clear()
       }
    }

    fun onPopulate() {
        uiScope.launch {
            populateEntryLogs()
        }
    }

    private suspend fun populateEntryLogs() {
        withContext(Dispatchers.IO) {
            database.insert(EntryLog(plate = "ABC-123"))
            database.insert(EntryLog(plate = "XYZ-123"))
        }
    }
}
