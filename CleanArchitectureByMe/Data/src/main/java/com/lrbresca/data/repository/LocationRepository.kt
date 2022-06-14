package com.lrbresca.data.repository

import com.lrbresca.data.DeviceLocationSource
import com.lrbresca.data.LocationPersistenceSource
import com.lrbresca.domain.Location

/**
 * The data layer has the objective of
 */
class LocationRepository (
    private val locationPersistenceSource: LocationPersistenceSource,
    private val deviceLocationSource: DeviceLocationSource
) {

    /**
     * Get the saved (older) location
     */
    fun getSavedLocations(): List<Location> {
        return locationPersistenceSource.getPersistedLocations()
    }

    /**
     * Get a new location
     */
    fun requestNewLocation(): List<Location> {
        val newLocation = deviceLocationSource.getDeviceLocation()
        locationPersistenceSource.saveNewLocation(newLocation)
        return getSavedLocations()
    }

}

