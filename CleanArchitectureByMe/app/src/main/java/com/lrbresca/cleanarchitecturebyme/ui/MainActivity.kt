package com.lrbresca.cleanarchitecturebyme.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lrbresca.cleanarchitecturebyme.ui.viewModel.Factory.ViewModelFactory
import com.lrbresca.cleanarchitecturebyme.ui.viewModel.MainViewModel
import com.lrbresca.cleanarchitecturebyme.ui.adapters.LocationAdapter
import com.lrbresca.cleanarchitecturebyme.databinding.ActivityMainBinding
import com.lrbresca.cleanarchitecturebyme.framework.FakeLocationSource
import com.lrbresca.cleanarchitecturebyme.framework.InMemoryLocationPersistenceSource
import com.lrbresca.cleanarchitecturebyme.ui.model.Location
import com.lrbresca.data.repository.LocationRepository
import com.lrbresca.usecase.GetLocations
import com.lrbresca.usecase.RequestNewLocation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val locationRepository: LocationRepository
    private val locationUseCase: GetLocations
    private val requestNewLocation: RequestNewLocation

    init {
        val persistence = InMemoryLocationPersistenceSource()
        val deviceLocation = FakeLocationSource()
        locationRepository = LocationRepository(persistence, deviceLocation)
        locationUseCase = GetLocations(locationRepository)
        requestNewLocation = RequestNewLocation(locationRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data = mutableListOf<Location>()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("my app", "the binding has the follow data: ${binding.textTest.text}")
        viewModel = ViewModelFactory(locationUseCase, requestNewLocation).run {
            ViewModelProvider(this@MainActivity, this).get(MainViewModel::class.java)
        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = LocationAdapter(data)

        binding.newLocationBtn.setOnClickListener {
            viewModel.newLocationClicked()
        }

        viewModel.locations.observe(this) {
            data.addAll(it)
            binding.recycler.adapter!!.notifyDataSetChanged()
        }
    }
}