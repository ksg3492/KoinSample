package com.example.koinsample.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinsample.network.api.GithubApi
import com.example.koinsample.network.api.WeatherApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(val githubApi: GithubApi, val weatherApi: WeatherApi) : ViewModel() {
    private var _text = MutableLiveData<String>("Hello")
    var text : LiveData<String> = _text

    fun requestGithubInfo() {
        githubApi.getUserInfo("ksg3492")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t1 ->
                if (t1.size > 0) {
                    _text.value = "my project name is ${t1[0].full_name}"
                } else {
                    _text.value = "my project is empty"
                }
            }
    }

    fun requestWeather() {
        weatherApi.getWeahter()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t1 ->
                if (t1 == null) {
                    _text.value = "weather is null"
                } else {
                    var _str = t1.title

                    t1.items?.let {
                        if (it.size > 0) {
                            _str += "\n최근공지사항 : ${it[0].title}"
                        } else {
                            _str += "\n최근공지사항 없음"
                        }
                    }
                    _text.value = _str
                }
            }
    }
}