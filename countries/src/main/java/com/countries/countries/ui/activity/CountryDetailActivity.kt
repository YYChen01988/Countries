package com.countries.countries.ui.activity

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import com.countries.countries.ui.fragment.CountriesFragment
import com.countries.databinding.ActivityCountryDetailBinding
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.memexpress.core.ui.activity.BaseActivity

class CountryDetailActivity : BaseActivity() {

    lateinit var activityCountryDetailBinding: ActivityCountryDetailBinding
//    lateinit var countriesFragment : CountriesFragment

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCountryDetailBinding = ActivityCountryDetailBinding.inflate(layoutInflater)
        val view = activityCountryDetailBinding.root
        setContentView(view)

        val name = intent.getStringExtra("NAME")
        val region = intent.getStringExtra("REGION")
        val subregion = intent.getStringExtra("SUBREGION")
        val flag = intent.getStringExtra("FLAG")
        val nativeName = intent.getStringExtra("NATIVE")
        val capital = intent.getStringExtra("CAPITAL")
        val population = intent.getStringExtra("POPULATION")
        val currencyCode = intent.getStringExtra("CURRENCY_CODE")
        val currencyName = intent.getStringExtra("CURRENCY_NAME")
        val currencySymbol = intent.getStringExtra("CURRENCY_SYMBOL")
        val language = intent.getStringExtra("LANGUAGE")
        val languageNative = intent.getStringExtra("LANGUAGE_NATIVE")

        activityCountryDetailBinding.apply {
            GlideToVectorYou.justLoadImage( this@CountryDetailActivity, Uri.parse(flag), flagImage)
            selectedCountryName.text = "${name} (${nativeName})"
            regionName.text = "Region: ${subregion}, ${region}"
            info1.text = "Capital: ${capital}"
            info2.text = "Population: ${population}"
            info3.text = "Currency: ${currencySymbol}, ${currencyCode}, ${currencyName}"
            info4.text = "Language: ${language} (${languageNative})"
        }
    }
}