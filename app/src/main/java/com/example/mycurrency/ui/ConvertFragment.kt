package com.example.mycurrency.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mycurrency.R
import com.example.mycurrency.databinding.FragmentConvertBinding
import com.example.mycurrency.viewmodels.CurrencyViewModel

class ConvertFragment : Fragment() {

    lateinit var binding: FragmentConvertBinding
    private val viewModel: CurrencyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_convert, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailsBtn.setOnClickListener {
            findNavController().navigate(ConvertFragmentDirections.actionConvertFragmentToOtherCurrenciesFragment())
        }
        binding.switchBtn.setOnClickListener { }
    }
}