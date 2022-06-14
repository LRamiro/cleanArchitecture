package com.lrbresca.usecase

import com.lrbresca.data.repository.LocationRepository
import com.lrbresca.domain.Location

class RequestNewLocation(private val locationsRepository: LocationRepository) {
    operator fun invoke(): List<Location> = locationsRepository.requestNewLocation()
}