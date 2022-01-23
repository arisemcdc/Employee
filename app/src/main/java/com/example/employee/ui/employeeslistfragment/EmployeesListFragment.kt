package com.example.employee.ui.employeeslistfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employee.Adapters.EmployeesAdapter
import com.example.employee.Employee
import com.example.employee.R
import com.example.employee.data.Repository.Repository
import com.example.employee.data.response.Response
/*import com.example.employee.ui.specialtylistfragment.SpecialtyListViewModel*/

import kotlinx.android.synthetic.main.employees_list_fragment.view.*

class EmployeesListFragment : Fragment(R.layout.employees_list_fragment), EmployeesView {

    val args: EmployeesListFragmentArgs by navArgs()
    private val presenter = EmployeesListPresenter(Repository())
    private lateinit var employeesAdapter: EmployeesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.bind(this)
        initView(view)
        presenter.setSpecialtyId(args.specialtyId)
        presenter.loadData()
    }

    override fun updateView(employees: List<Response>) {
        employeesAdapter.updateList(employees)
    }

    private fun initView(view: View) {
        view.employeesListRecyclerView.layoutManager = LinearLayoutManager(context)
        val listener = object : EmployeesAdapter.Listener {
            override fun onClickEmployee(employee: Response) {
            }
        }
        employeesAdapter = EmployeesAdapter(listener)
        view.employeesListRecyclerView.adapter = employeesAdapter
    }

    override fun onDestroyView() {
        presenter.unbind()
        super.onDestroyView()
    }
}
