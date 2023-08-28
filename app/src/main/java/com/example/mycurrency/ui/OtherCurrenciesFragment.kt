package com.example.mycurrency.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mycurrency.R
import com.example.mycurrency.databinding.FragmentOtherCurrenciesBinding
import com.example.mycurrency.viewmodels.CurrencyViewModel
import com.example.mycurrency.viewmodels.LatestDataResult
import kotlinx.coroutines.launch

class OtherCurrenciesFragment : Fragment() {

    lateinit var binding: FragmentOtherCurrenciesBinding
    private val viewModel: CurrencyViewModel by activityViewModels()
    private val currencyAdapter = CurrencyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_other_currencies, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCurrency.adapter = currencyAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loadLatest()
                viewModel.latestData.collect { latest ->
                    when (latest) {
                        is LatestDataResult.Success -> currencyAdapter.setData(latest.latestModel!!.rates)
                        is LatestDataResult.Error -> println(latest.ex.message)
                    }

                }

            }
        }

    }

}