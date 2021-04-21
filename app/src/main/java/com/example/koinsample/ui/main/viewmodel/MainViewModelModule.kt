package com.example.koinsample.ui.main.viewmodel

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
}