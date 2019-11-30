package com.norbertneudert.openmygarage.ui.main.logTab

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.norbertneudert.openmygarage.TextItemViewHolder
import com.norbertneudert.openmygarage.database.EntryLog

class EntryLogAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
    var data = listOf<EntryLog>()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.plate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}