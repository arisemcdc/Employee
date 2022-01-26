package com.example.employee.ui.detailemployeeinfofragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.DocumentsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.employee.R
import com.example.employee.data.Repository.Repository
import com.example.employee.data.response.Response
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_employee_info_fragment.*
import kotlinx.android.synthetic.main.detail_employee_info_fragment.view.*

class DetailEmployeeInfoFragment : Fragment(R.layout.detail_employee_info_fragment), DetailEmployeeInfoView {

    lateinit var root: View
    val args: DetailEmployeeInfoFragmentArgs by navArgs()
    private val presenter = DetailEmployeeInfoPresenter(Repository())
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.detail_employee_info_fragment, container, false)
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.bind(this)
        initView(view)
        presenter.setAvatrUrl(args.avatrUrl)
        presenter.loadData()
    }


    override fun updateView(employee: Response) {
        root.firstNameTextView.setText(employee.fName)
        root.lastNameTextview.setText(employee.lName)
        root.birthdayTextView.setText(employee.birthday)
        root.specialtyTextView.setText(employee.specialty.toString())
        Picasso.with(context)
                .load(employee.avatrUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(employeeImageView, object: com.squareup.picasso.Callback {
                    override fun onSuccess() {
                    }
                    override fun onError() {
                    }
                } )
    }

    override fun onDestroyView() {
        presenter.unbind()
        super.onDestroyView()
    }

    private fun initView(view: View){

    }
}