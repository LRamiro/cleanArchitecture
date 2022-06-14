package com.lrbresca.cleanarchitecturebyme.framework

import com.lrbresca.data.LocationPersistenceSource
import com.lrbresca.domain.Location

/**
 * This class is in charge of make the local persistence
 */
class InMemoryLocationPersistenceSource : LocationPersistenceSource {
    private var locations: List<Location> = emptyList()

    override fun getPersistedLocations(): List<Location> = locations

    override fun saveNewLocation(location: Location) {
        locations += location
    }
}