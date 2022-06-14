package com.lrbresca.data

import com.lrbresca.domain.Location

interface LocationPersistenceSource {

    fun getPersistedLocations(): List<Location>
    fun saveNewLocation(location: Location)

}