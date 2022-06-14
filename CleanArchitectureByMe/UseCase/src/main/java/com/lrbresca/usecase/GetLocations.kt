package com.lrbresca.usecase

import com.lrbresca.data.repository.LocationRepository
import com.lrbresca.domain.Location

class GetLocations(private val locationsRepository: LocationRepository) {
    operator fun invoke(): List<Location> = locationsRepository.getSavedLocations()
}