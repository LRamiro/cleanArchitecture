package com.lrbresca.cleanarchitecturebyme.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lrbresca.cleanarchitecturebyme.ui.model.Location
import com.lrbresca.cleanarchitecturebyme.ui.toPresentationModel
import com.lrbresca.usecase.GetLocations
import com.lrbresca.usecase.RequestNewLocation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getLocations: GetLocations,
    private val requestNewLocation: RequestNewLocation
) : ViewModel() {

    // internal
    private val _locations = MutableLiveData<List<Location>>()
    //external
    val locations: LiveData<List<Location>>
        get() = _locations

    init {
        //getLocations()
    }

    private fun getLocations() {
        viewModelScope.launch(Dispatchers.Main) {
            _locations.value = getLocations.invoke().map(com.lrbresca.domain.Location::toPresentationModel)
        }
    }

    fun newLocationClicked() {
        viewModelScope.launch(Dispatchers.Main) {
            _locations.value = requestNewLocation().map(com.lrbresca.domain.Location::toPresentationModel)
        }
    }

}