package com.memexpress.memes.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.memexpress.core.network.Resource
import com.countries.countries.repository.CountriesRepository
import com.countries.countries.viewmodel.CountriesViewModel
import com.memexpress.memes.utils.TestCoroutineRule
import com.pasindulaksara.recyclergrid.Country
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CountriesViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var countriesRepository: CountriesRepository

    @Mock
    private lateinit var apiCountriesObserver: Observer<Resource<List<Country>>>

    private lateinit var viewModel: CountriesViewModel

    @Before
    fun setUp() {
        viewModel = CountriesViewModel(countriesRepository)
    }

    @Test
    fun `given server response 200 when fetch should return success`() {
        startFetchingCuntryResult(Resource.success(data = emptyList()))
    }

    @Test
    fun `given server response error when fetch should return error`() {
        val errorMessage = "Dummy Error Message"
        startFetchingCuntryResult(
            Resource.error(
                data = null,
                RuntimeException(errorMessage).toString()
            )
        )

    }

    private fun startFetchingCuntryResult(data: Resource<List<Country>>) {
        testCoroutineRule.runBlockingTest {
            Mockito.doReturn(data).`when`(countriesRepository).getCountries()
            viewModel.fetchAllCountries()
            viewModel.getAllCountries().observeForever(apiCountriesObserver)

            Mockito.verify(countriesRepository).getCountries()
            Mockito.verify(apiCountriesObserver).onChanged(data)
            viewModel.getAllCountries().removeObserver(apiCountriesObserver)
        }
    }
}

