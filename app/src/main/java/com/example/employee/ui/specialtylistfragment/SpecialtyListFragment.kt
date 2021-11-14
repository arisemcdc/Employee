package com.example.employee.ui.specialtylistfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.employee.R
import kotlinx.android.synthetic.main.specialty_list_fragment.view.*

class SpecialtyListFragment : Fragment() {

    companion object {
        fun newInstance() = SpecialtyListFragment()
    }

    private lateinit var viewModel: SpecialtyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SpecialtyListViewModel::class.java)
        val root = inflater.inflate(R.layout.specialty_list_fragment, container, false)
        viewModel.employeesInfo.observe(viewLifecycleOwner, Observer {
            root.responseTextView.setText(viewModel.employeesInfo.value.toString())
        })
        return root
    }

  /*  override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialtyListViewModel::class.java)
        viewModel.employeesInfo.observe(viewLifecycleOwner, Observer {

        })
    }*/
}