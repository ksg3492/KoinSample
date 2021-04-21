package com.example.koinsample.network

import android.util.Log
import com.example.koinsample.network.api.GithubApi
import com.example.koinsample.network.api.WeatherApi
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                Log.e("SG2","network Interceptor")
                chain.proceed(chain.request())
            }
            .connectTimeout(10 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(10 * 1000, TimeUnit.MILLISECONDS)
            .writeTimeout(10 * 1000, TimeUnit.MILLISECONDS)
            .build()
    }

    ////////////////////////////

    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(get())
            .build()
    }

    single(named("weather")) {
        Retrofit.Builder()
            .baseUrl("http://www.kma.go.kr/")
            .addConverterFactory(TikXmlConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(get())
            .build()
    }
}

val githubModule = module {
    single {
        get<Retrofit>().create(GithubApi::class.java)
    }
}

val weatherModule = module {
    single {
        get<Retrofit>(named("weather")).create(WeatherApi::class.java)
    }
}