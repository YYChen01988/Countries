package com.countries.countries.data.service

import com.countries.countries.data.api.CountriesApi

class CountriesService(private val countriesApi: CountriesApi) {
    suspend fun getCountries() = countriesApi.getCountries()
}
