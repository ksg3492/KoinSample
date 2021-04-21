package com.example.koinsample.ui.main.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.koinsample.network.api.GithubApi
import com.example.koinsample.network.api.WeatherApi
import com.example.koinsample.ui.main.viewmodel.MainViewModel

class MainViewModelFactory(val githubApi: GithubApi, val weatherApi: WeatherApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(githubApi, weatherApi) as T
        } else {
            throw IllegalAccessError()
        }
    }
}