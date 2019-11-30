package com.norbertneudert.openmygarage.ui.main.logTab

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.norbertneudert.openmygarage.R
import com.norbertneudert.openmygarage.databinding.LogTabFragmentBinding

class LogTabFragment : Fragment() {

    companion object {
        fun newInstance() = LogTabFragment()
    }

    private lateinit var viewModel: LogTabViewModel
    private lateinit var binding: LogTabFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(LogTabViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.log_tab_fragment, container, false)
        binding.setLifecycleOwner(this)

        return binding.root
    }
}
