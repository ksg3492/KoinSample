package com.example.koinsample.network.api

import com.example.koinsample.network.data.UserInfo
import com.example.koinsample.network.data.UserInfos
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    //https://api.github.com/users/ksg3492/repos
    @GET("users/{id}/repos")
    fun getUserInfo(@Path("id") userId : String) : Single<ArrayList<UserInfo>>
}