package com.countries.countries.ui.activity

import android.os.Bundle
import com.countries.databinding.ActivityCountriesBinding
import com.memexpress.core.ui.activity.BaseActivity

class CountriesActivity : BaseActivity() {
    lateinit var activityCountriesBinding: ActivityCountriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCountriesBinding = ActivityCountriesBinding.inflate(layoutInflater)
        val view = activityCountriesBinding.root
        setContentView(view)
    }
}
