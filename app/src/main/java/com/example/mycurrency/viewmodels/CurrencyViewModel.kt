package com.example.mycurrency.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycurrency.models.LatestDataModel
import com.example.mycurrency.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {
    private val _convert = MutableStateFlow<LatestDataResult>(LatestDataResult.Success(null))
    val latestData: StateFlow<LatestDataResult> = _convert

    fun loadLatest() {
        viewModelScope.launch {
            repository.getLatestData()
                .catch { ex ->
                    _convert.value = LatestDataResult.Error(ex)
                }
                .collect { data ->
                    _convert.value = LatestDataResult.Success(data)
                }
        }
    }
}

sealed class LatestDataResult {
    data class Success(val latestModel: LatestDataModel?) : LatestDataResult()
    data class Error(val ex: Throwable) : LatestDataResult()
}