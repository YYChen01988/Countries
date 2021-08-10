package com.countries.countries.injection

import com.countries.countries.data.api.CountriesApi
import com.countries.countries.data.service.CountriesService
import com.countries.countries.repository.CountriesRepository
import com.countries.countries.viewmodel.CountriesViewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val countriesModule = module {
    factory {
        CountriesViewModel(
            memesRepository = get()
        )
    }
    factory {
        val retrofit: Retrofit = get()
        retrofit.create(CountriesApi::class.java)
    }
    factory {
        CountriesService(get())
    }
    factory {
        CountriesRepository(get(), get())
    }
}
