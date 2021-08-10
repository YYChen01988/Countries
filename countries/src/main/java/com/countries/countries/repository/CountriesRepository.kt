package com.countries.countries.repository

import com.countries.core.network.ResponseHandler
import com.countries.countries.data.service.CountriesService

class CountriesRepository(
    private val countriesService: CountriesService,
    private val responseHandler: ResponseHandler
) {
    suspend fun getCountries() = try {
        val response = countriesService.getCountries()
        responseHandler.handleSuccess(data = response)
    } catch (e: Exception) {
        responseHandler.handleException(e)
    }
}
