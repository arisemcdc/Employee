package com.example.employee.ui.specialtylistfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employee.Adapters.SpecialtyListAdapter
import com.example.employee.R
import com.example.employee.data.Repository.Repository
import com.example.employee.data.response.Specialty
import com.example.employee.interfaces.MyInterface
import kotlinx.android.synthetic.main.specialty_list_fragment.*
import kotlinx.android.synthetic.main.specialty_list_fragment.view.*
class SpecialtyListFragment: Fragment(), MyInterface.specialtyView {
    private val presenter = SpecialtyListPresenter(Repository())
    lateinit var specialtyListAdapter: SpecialtyListAdapter
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.specialty_list_fragment, container, false)
        root.specialtyListRecyclerView.layoutManager = LinearLayoutManager(context)
        updateView()
        return root
    }

    override fun updateView() {
        specialtyListAdapter = SpecialtyListAdapter(presenter.getData(), this)
    }
}




















/*
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
        return inflater.inflate(R.layout.specialty_list_fragment, container, false)
        viewModel = ViewModelProvider(this).get(SpecialtyListViewModel::class.java)
        val root = inflater.inflate(R.layout.specialty_list_fragment, container, false)
        root.specialtyListRecyclerView.layoutManager = LinearLayoutManager(context)
        */
/* *//*
*/
/* specialties = viewModel.convertSpecialtyClass(viewModel.listResponse.value!!)*//*
*/
/*
        *//*
*/
/*viewModel.specialties.observe(viewLifecycleOwner, Observer {
           specialtyListAdaapter = SpecialtyListAdaapter(it, this)
           specialtyListRecyclerView.adapter = specialtyListAdaapter
        })*//*
*/
/*
        viewModel.specialtyList.observe(viewLifecycleOwner, Observer {
          specialtyListAdaapter = SpecialtyListAdaapter(it, this)
          specialtyListRecyclerView.adapter = specialtyListAdaapter
       })
        specialtyListAdaapter = SpecialtyListAdaapter(specialties, this)
        specialtyListRecyclerView.adapter = specialtyListAdaapter*//*

        specialtyListAdaapter = SpecialtyListAdaapter(viewModel.specialtyList,this)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialtyListViewModel::class.java)
        // TODO: Use the ViewModel
        override fun onClickDay(specialty: Specialty) {
            val action = SpecialtyListFragmentDirections.actionspecialtyListFragmenttoemployeesListFragment(specialty.name)

        }

        */
/*  override fun onActivityCreated(savedInstanceState: Bundle?) {
              super.onActivityCreated(savedInstanceState)
              viewModel = ViewModelProvider(this).get(SpecialtyListViewModel::class.java)
              viewModel.employeesInfo.observe(viewLifecycleOwner, Observer {
              })
          }*//*

    } */
