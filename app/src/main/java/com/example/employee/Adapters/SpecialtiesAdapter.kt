package com.example.employee.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employee.R
import com.example.employee.data.response.Specialty
import kotlinx.android.synthetic.main.specialty_item.view.*

class SpecialtiesAdapter (val listener: Listener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var specialties: List<Specialty> = emptyList()

    interface Listener {
        fun onClickSpecialty(specialty: Specialty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = SpecialtyHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.specialty_item, parent, false)
        )
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.specialty != null)
                listener.onClickSpecialty(viewHolder.specialty!!)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SpecialtyHolder)
            holder.specialty = specialties[position]
    }

    override fun getItemCount(): Int {
        return specialties.size
    }

    fun updateList(specialties: List<Specialty>) {
        this.specialties = specialties
        notifyDataSetChanged()
    }

}
class SpecialtyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var specialty: Specialty? = null
    set(value) {
        field = value
        itemView.specialtyTextView.text = value?.name
    }
}