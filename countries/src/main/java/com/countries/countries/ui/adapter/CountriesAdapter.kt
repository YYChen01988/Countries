package com.countries.countries.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memexpress.core.ui.activity.BaseActivity
import com.countries.databinding.ListItemCountryBinding
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.pasindulaksara.recyclergrid.Country

class CountriesAdapter(private val activity: BaseActivity, private val countries: List<Country>) :
    RecyclerView.Adapter<CountriesAdapter.CountriesAdapterViewHolder>() {

    var countryClicked: ((Country) -> Unit)? = null

    var dataList = emptyList<Country>()

    internal fun setDataList(dataList: List<Country>) {
        this.dataList = dataList
    }

    class CountriesAdapterViewHolder(val listItemCountryBinding: ListItemCountryBinding) :
        RecyclerView.ViewHolder(listItemCountryBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesAdapterViewHolder =
        CountriesAdapterViewHolder(
            ListItemCountryBinding.inflate(
                LayoutInflater.from(activity),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: CountriesAdapterViewHolder, position: Int) {
        val country = countries[position]
        holder.listItemCountryBinding.apply {
            subregion.text = country.subregion
            countryName.text = country.name
            countryCard.setOnClickListener {
                countryClicked?.invoke(country)
            }
            GlideToVectorYou.justLoadImage(activity, Uri.parse(country.flag), countryFlag)
        }
    }

    override fun getItemCount(): Int = countries.count()
}
