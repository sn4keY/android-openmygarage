package com.norbertneudert.openmygarage.ui.main.plateTab

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.norbertneudert.openmygarage.R
import com.norbertneudert.openmygarage.databinding.PlateTabFragmentBinding

class PlateTabFragment : Fragment() {

    companion object {
        fun newInstance() = PlateTabFragment()
    }

    private lateinit var viewModel: PlateTabViewModel
    private lateinit var binding: PlateTabFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(PlateTabViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.plate_tab_fragment, container, false)
        binding.setLifecycleOwner(this)

        return binding.root
    }
}
