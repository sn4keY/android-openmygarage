package com.norbertneudert.openmygarage.ui.main.plateTab

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.norbertneudert.openmygarage.PlatesViewHolder
import com.norbertneudert.openmygarage.R
import com.norbertneudert.openmygarage.database.StoredPlate

class PlateAdapter(val viewModel: PlateTabViewModel) : RecyclerView.Adapter<PlatesViewHolder>() {
    var data = listOf<StoredPlate>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PlatesViewHolder, position: Int) {
        val item = data[position]
        holder.nameTextView.text = item.name
        holder.plateTextView.text = item.plate
        holder.outcomeTextView.text = item.outcome.toString()
        holder.deleteButton.setOnClickListener {
            viewModel.onDelete(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.plates_item_view, parent, false)
        return PlatesViewHolder(view)
    }
}