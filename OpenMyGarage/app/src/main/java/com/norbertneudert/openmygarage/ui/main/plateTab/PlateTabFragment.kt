package com.norbertneudert.openmygarage.ui.main.plateTab

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.norbertneudert.openmygarage.R
import com.norbertneudert.openmygarage.database.OMGDatabase
import com.norbertneudert.openmygarage.databinding.PlateTabFragmentBinding
import com.norbertneudert.openmygarage.ui.main.logTab.LogTabViewModelFactory

class PlateTabFragment : Fragment() {

    companion object {
        fun newInstance() = PlateTabFragment()
    }

    private lateinit var viewModel: PlateTabViewModel
    private lateinit var binding: PlateTabFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.plate_tab_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = OMGDatabase.getInstance(application).storedPlate
        val viewModelFactory = PlateTabViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PlateTabViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.onClear()
        viewModel.onPopulate()

        val adapter = PlateAdapter(viewModel)
        binding.plateList.adapter = adapter

        viewModel.plates.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return binding.root
    }
}
