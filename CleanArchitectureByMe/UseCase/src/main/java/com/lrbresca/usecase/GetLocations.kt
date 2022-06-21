package com.lrbresca.usecase

import com.lrbresca.data.repository.LocationRepository
import com.lrbresca.domain.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetLocations(private val locationsRepository: LocationRepository) {
    suspend operator fun invoke(): List<Location>{
        val locations = withContext(Dispatchers.IO) {
            return@withContext locationsRepository.getSavedLocations()
        }

        return locations
    }
}