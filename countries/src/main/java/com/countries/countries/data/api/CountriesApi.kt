package com.countries.countries.data.api

import com.pasindulaksara.recyclergrid.Country
import retrofit2.http.GET

interface CountriesApi {

    @GET("rest/v2/all")
    suspend fun getCountries(): List<Country>
}
