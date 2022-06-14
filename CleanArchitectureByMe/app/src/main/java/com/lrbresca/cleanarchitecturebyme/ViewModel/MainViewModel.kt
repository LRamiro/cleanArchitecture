package com.lrbresca.cleanarchitecturebyme.ViewModel

class MainViewModel {


    fun onCreate() = launch(UI) {
        val locations = bg { getLocations() }.await()
        view?.renderLocations(locations)
    }
    fun newLocationClicked() = launch(UI) {
        val locations = bg { requestNewLocation() }.await()
        view?.renderLocations(locations)
    }
    fun onDestroy() {
        view = null
    }
}