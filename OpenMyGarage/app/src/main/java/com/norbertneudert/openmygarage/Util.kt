package com.norbertneudert.openmygarage

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LogsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var plateTextView: TextView
    var timeTextView: TextView
    var outcomeTextView: TextView

    init {
        plateTextView = itemView.findViewById(R.id.plate_logs_tw)
        timeTextView = itemView.findViewById(R.id.time_logs_tw)
        outcomeTextView = itemView.findViewById(R.id.outcome_logs_tw)
    }
}
