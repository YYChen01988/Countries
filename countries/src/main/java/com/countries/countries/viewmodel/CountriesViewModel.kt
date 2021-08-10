package com.countries.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memexpress.core.network.Resource
import com.countries.countries.repository.CountriesRepository
import com.pasindulaksara.recyclergrid.Country
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val memesRepository: CountriesRepository,
) : ViewModel() {
    private val allCountries: MutableLiveData<Resource<List<Country>>> = MutableLiveData<Resource<List<Country>>>()

    fun fetchAllCountries() {
        viewModelScope.launch {
            allCountries.postValue(Resource.loading(data = null))
            allCountries.postValue(memesRepository.getCountries())
        }
    }

    fun getAllCountries() = allCountries
}
