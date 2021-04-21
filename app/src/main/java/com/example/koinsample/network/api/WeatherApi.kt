package com.example.koinsample.network.api

import com.example.koinsample.network.data.WeatherInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface WeatherApi {
    //http://www.kma.go.kr/servlet/NeoboardProcess?mode=rss&bid=gongzi&url=http%3A%2F%2Fwww.kma.go.kr%2Fnotify%2Fnotice%2Flist.jsp
    @GET("servlet/NeoboardProcess?mode=rss&bid=gongzi&url=http%3A%2F%2Fwww.kma.go.kr%2Fnotify%2Fnotice%2Flist.jsp")
    fun getWeahter() : Single<WeatherInfo>
}