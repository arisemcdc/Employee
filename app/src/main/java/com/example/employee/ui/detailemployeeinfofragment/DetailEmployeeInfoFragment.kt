package com.example.employee.ui.detailemployeeinfofragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.employee.R

class DetailEmployeeInfoFragment : Fragment() {

    companion object {
        fun newInstance() = DetailEmployeeInfoFragment()
    }

    private lateinit var viewModel: DetailEmployeeInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_employee_info_fragment, container, false)
    }
//
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailEmployeeInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}