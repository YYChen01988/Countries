package com.countries.application

import android.app.Application
import com.memexpress.BuildConfig
import com.memexpress.core.injections.networkModule
import com.countries.countries.injection.countriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CountriesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger(Level.ERROR)
            }
            androidContext(this@CountriesApp)
            modules(listOf(networkModule, countriesModule))
        }
    }
}
