package com.example.koinsample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.koinsample.R
import com.example.koinsample.databinding.ActivityMainBinding
import com.example.koinsample.ui.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val vm : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        vm.text.observe(this, Observer {
            binding.tvMain.text = it
        })

        binding.btGithub.setOnClickListener {
            vm.requestGithubInfo()
        }
        binding.btWeather.setOnClickListener {
            vm.requestWeather()
        }
    }
}