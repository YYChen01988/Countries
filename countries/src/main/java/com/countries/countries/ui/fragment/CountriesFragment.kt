package com.countries.countries.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.countries.R
import com.countries.countries.ui.activity.CountryDetailActivity
import com.countries.countries.ui.adapter.CountriesAdapter
import com.countries.countries.viewmodel.CountriesViewModel
import com.countries.databinding.FragmentCountriesBinding
import com.countries.core.network.Status
import com.countries.core.ui.activity.BaseActivity
import com.countries.core.ui.fragments.BaseFragment
import com.pasindulaksara.recyclergrid.Country
import org.koin.android.ext.android.inject

class CountriesFragment : BaseFragment() {

    private val countriesViewModel: CountriesViewModel by inject()

    private lateinit var countriesAdapter: CountriesAdapter

    private lateinit var navController: NavController

    private lateinit var fragmentCountriesBinding: FragmentCountriesBinding

    override fun getErrorView(): View = fragmentCountriesBinding.errorView.root

    override fun getErrorMessageTextView(): TextView = fragmentCountriesBinding.errorView.tvError

    override fun getSuccessView(): View = fragmentCountriesBinding.countriesSuccess.root

    override fun getWaitingView(): View = fragmentCountriesBinding.waitView.root

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCountriesBinding = FragmentCountriesBinding.inflate(inflater, container, false)
        return fragmentCountriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        countriesViewModel.getAllCountries().observe(
            viewLifecycleOwner,
            {
                when (it.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        showSuccessResponse()
                        loadData(it.data)
                    }
                    Status.ERROR -> showError(it.message ?: getString(R.string.error_loading_data))
                }
            }
        )
        countriesViewModel.fetchAllCountries()
    }

    private fun loadData(countries: List<Country>?) {
        countries?.let {
            loadCountriesInRecyclerView(it)
        } ?: showError(getString(R.string.error_loading_data))
    }

    private fun loadCountriesInRecyclerView(countries: List<Country>) {
        fragmentCountriesBinding.countriesSuccess.rvCountries.apply {
            countriesAdapter = CountriesAdapter(activity as BaseActivity, countries)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = countriesAdapter
            countriesAdapter.setDataList(countries)
        }
        countriesAdapter.countryClicked = {

            val intent = Intent(activity, CountryDetailActivity::class.java)
            intent.putExtra("FLAG", it.flag)
            intent.putExtra("NAME", it.name)
            intent.putExtra("REGION", it.region)
            intent.putExtra("SUBREGION", it.subregion)
            intent.putExtra("CAPITAL", it.capital)
            intent.putExtra("NATIVE", it.nativeName)
            intent.putExtra("POPULATION", it.population.toString())
            intent.putExtra("CURRENCY_CODE", it.currencies?.first()?.code)
            intent.putExtra("CURRENCY_NAME", it.currencies?.first()?.name)
            intent.putExtra("CURRENCY_SYMBOL", it.currencies?.first()?.symbol)
            intent.putExtra("LANGUAGE", it.languages?.first()?.name)
            intent.putExtra("LANGUAGE_NATIVE", it.languages?.first()?.nativeName)

            startActivity(intent)

        }
    }
}
