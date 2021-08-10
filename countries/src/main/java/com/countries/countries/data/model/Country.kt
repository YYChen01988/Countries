package com.pasindulaksara.recyclergrid

import com.countries.countries.data.model.Currency
import com.countries.countries.data.model.Language
import com.countries.countries.data.model.RegionalBloc
import com.countries.countries.data.model.Translations
import com.google.gson.annotations.SerializedName


data class Country(

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("topLevelDomain")
    val topLevelDomain: List<String>? = null,

    @SerializedName("alpha2Code")
    val alpha2Code: String? = null,

    @SerializedName("alpha3Code")
    val alpha3Code: String? = null,

    @SerializedName("callingCodes")
    val callingCodes: List<String>? = null,

    @SerializedName("capital")
    val capital: String? = null,

    @SerializedName("altSpellings")
    val altSpellings: List<String>? = null,

    @SerializedName("region")
    val region: String? = null,

    @SerializedName("subregion")
    val subregion: String? = null,

    @SerializedName("population")
    val population: Int,

    @SerializedName("latlng")
    val latlng: List<Double>? = null,

    @SerializedName("demonym")
    val demonym: String? = null,

    @SerializedName("area")
    val area: Double? = null,

    @SerializedName("gini")
    val gini: Double? = null,

    @SerializedName("timezones")
    val timezones: List<String>? = null,

    @SerializedName("borders")
    val borders: List<String>? = null,

    @SerializedName("nativeName")
    val nativeName: String? = null,

    @SerializedName("numericCode")
    val numericCode: String? = null,

    @SerializedName("currencies")
    val currencies: List<Currency>? = null,

    @SerializedName("languages")
    val languages: List<Language>? = null,

    @SerializedName("translations")
    val translations: Translations? = null,

    @SerializedName("flag")
    val flag: String,

    @SerializedName("regionalBlocs")
    val regionalBlocs: List<RegionalBloc>? = null,

    @SerializedName("cioc")
    val cioc: String
)