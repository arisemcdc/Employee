package com.example.employee.ui.specialtylistfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employee.Adapters.SpecialtiesAdapter
import com.example.employee.R
import com.example.employee.data.Repository.Repository
import com.example.employee.data.response.Specialty
import kotlinx.android.synthetic.main.specialty_list_fragment.view.*
class SpecialtyListFragment: Fragment(R.layout.specialty_list_fragment), SpecialtyView {

    private val presenter = SpecialtyListPresenter(Repository())
    private lateinit var specialtiesAdapter: SpecialtiesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.bind(this)
        initView(view)
        presenter.loadData()
    }

    override fun updateView(specialties: List<Specialty>) {
        specialtiesAdapter.updateList(specialties)
    }

    private fun initView(view: View) {
        view.specialtyListRecyclerView.layoutManager = LinearLayoutManager(context)
        val listener = object : SpecialtiesAdapter.Listener{
            override fun onClickSpecialty(specialty: Specialty) {
            }
        }
        specialtiesAdapter = SpecialtiesAdapter(listener)
        view.specialtyListRecyclerView.adapter = specialtiesAdapter
    }

    override fun onDestroyView() {
        presenter.unbind()
        super.onDestroyView()
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
