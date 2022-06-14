package com.lrbresca.data

import com.lrbresca.domain.Location

interface DeviceLocationSource {

    fun getDeviceLocation(): Location

}