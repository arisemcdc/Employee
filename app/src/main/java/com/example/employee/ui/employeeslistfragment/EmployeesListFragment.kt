package com.example.employee.ui.employeeslistfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.employee.R
import com.example.employee.ui.specialtylistfragment.SpecialtyListViewModel
import kotlinx.android.synthetic.main.employees_list_fragment.view.*
import kotlinx.android.synthetic.main.specialty_list_fragment.view.*

class EmployeesListFragment : Fragment() {

    companion object {
        fun newInstance() = EmployeesListFragment()
    }

    private lateinit var viewModel: EmployeesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(EmployeesListViewModel::class.java)
        val root = inflater.inflate(R.layout.employees_list_fragment, container, false)
        viewModel.employeesInfo.observe(viewLifecycleOwner, Observer{
            root.responseTextView.setText(viewModel.employeesInfo.value.toString())
        })
        return root
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmployeesListViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}