package com.example.employee.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employee.R
import com.example.employee.data.response.Response
import com.example.employee.data.response.Specialty
import kotlinx.android.synthetic.main.employee_item.view.*

class EmployeesListAdapter (val employeesList: List<Response>, val listener: Listener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    interface Listener {
        fun onClickEmployee(specialty: Specialty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = EmployeeHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.employee_item, parent, false)
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is EmployeeHolder)
            holder.employee = employeesList[position]
    }

    override fun getItemCount(): Int {
        return employeesList.size
    }
}
class EmployeeHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var employee: Response? = null
    set(value)  {
        field = value
        itemView.firstNameTextView.text = value?.fName
        itemView.lastNameTextView.text = value?.lName
        itemView.birthdayTextView.text=value?.birthday
    }
}