package com.norbertneudert.openmygarage.ui.main.logTab

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.norbertneudert.openmygarage.R
import com.norbertneudert.openmygarage.TextItemViewHolder
import com.norbertneudert.openmygarage.database.EntryLog

class EntryLogAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
    var data = listOf<EntryLog>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        var text: String = item.plate.plus(item.entryTime.toString())
        holder.textView.text = text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}