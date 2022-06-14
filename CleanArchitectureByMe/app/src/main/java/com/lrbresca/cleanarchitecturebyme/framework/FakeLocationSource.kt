package com.lrbresca.cleanarchitecturebyme.framework

import com.lrbresca.data.DeviceLocationSource
import com.lrbresca.domain.Location
import java.util.*

/**
 * This class is in charge of generate the current location of the device
 */
class FakeLocationSource : DeviceLocationSource {
    private val random = Random(System.currentTimeMillis())
    override fun getDeviceLocation(): Location =
        Location(random.nextDouble() * 180 - 90,
            random.nextDouble() * 360 - 180, Date())
}