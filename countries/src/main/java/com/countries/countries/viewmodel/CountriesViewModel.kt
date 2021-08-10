package com.countries.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.countries.core.network.Resource
import com.countries.countries.repository.CountriesRepository
import com.pasindulaksara.recyclergrid.Country
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val countriesRepository: CountriesRepository,
) : ViewModel() {
    private val allCountries: MutableLiveData<Resource<List<Country>>> = MutableLiveData<Resource<List<Country>>>()

    fun fetchAllCountries() {
        viewModelScope.launch {
            allCountries.postValue(Resource.loading(data = null))
            allCountries.postValue(countriesRepository.getCountries())
        }
    }

    fun getAllCountries() = allCountries
}
