package com.example.koinsample

import androidx.multidex.MultiDexApplication
import com.example.koinsample.network.githubModule
import com.example.koinsample.network.networkModule
import com.example.koinsample.network.weatherModule
import com.example.koinsample.ui.main.viewmodel.mainViewModelModule
import org.koin.android.java.KoinAndroidApplication
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class AppApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        val koinApplication = KoinAndroidApplication.create(applicationContext)
            .modules(
                networkModule,
                mainViewModelModule,
                githubModule,
                weatherModule
            )

        startKoin(GlobalContext, koinApplication)
    }
}