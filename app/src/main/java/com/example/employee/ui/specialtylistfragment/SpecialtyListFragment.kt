package com.example.employee.ui.specialtylistfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employee.Adapters.SpecialtyListAdaapter
import com.example.employee.R
import com.example.employee.data.response.Specialty
import kotlinx.android.synthetic.main.specialty_list_fragment.*
import kotlinx.android.synthetic.main.specialty_list_fragment.view.*

class SpecialtyListFragment : Fragment(), SpecialtyListAdaapter.Listener {

    companion object {
        fun newInstance() = SpecialtyListFragment()
    }

    private lateinit var viewModel: SpecialtyListViewModel
    lateinit var specialtyListAdaapter: SpecialtyListAdaapter
    lateinit var specialties:List<Specialty>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewModel = ViewModelProvider(this).get(SpecialtyListViewModel::class.java)
        val root = inflater.inflate(R.layout.specialty_list_fragment, container, false)
        root.specialtyListRecyclerView.layoutManager = LinearLayoutManager(context)
      /* *//* specialties = viewModel.convertSpecialtyClass(viewModel.listResponse.value!!)*//*
        *//*viewModel.specialties.observe(viewLifecycleOwner, Observer {
           specialtyListAdaapter = SpecialtyListAdaapter(it, this)
           specialtyListRecyclerView.adapter = specialtyListAdaapter
        })*//*
        viewModel.specialtyList.observe(viewLifecycleOwner, Observer {
          specialtyListAdaapter = SpecialtyListAdaapter(it, this)
          specialtyListRecyclerView.adapter = specialtyListAdaapter
       })
        specialtyListAdaapter = SpecialtyListAdaapter(specialties, this)
        specialtyListRecyclerView.adapter = specialtyListAdaapter*/
        specialtyListAdaapter = SpecialtyListAdaapter(viewModel.specialtyList,this)

        return root
    }

    override fun onClickDay(specialty: Specialty) {
        val action = SpecialtyListFragmentDirections.actionspecialtyListFragmenttoemployeesListFragment(specialty.name)

    }

    /*  override fun onActivityCreated(savedInstanceState: Bundle?) {
          super.onActivityCreated(savedInstanceState)
          viewModel = ViewModelProvider(this).get(SpecialtyListViewModel::class.java)
          viewModel.employeesInfo.observe(viewLifecycleOwner, Observer {

          })
      }*/
}