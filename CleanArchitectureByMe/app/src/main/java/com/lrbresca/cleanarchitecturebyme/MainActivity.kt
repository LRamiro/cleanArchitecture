package com.lrbresca.cleanarchitecturebyme

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.lrbresca.cleanarchitecturebyme.framework.FakeLocationSource
import com.lrbresca.cleanarchitecturebyme.framework.InMemoryLocationPersistenceSource
import com.lrbresca.data.repository.LocationRepository

class MainActivity : AppCompatActivity() {

    init {
        val persistence = InMemoryLocationPersistenceSource()
        val deviceLocation = FakeLocationSource()
        val locationsRepository = LocationRepository(persistence, deviceLocation)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

    }
}