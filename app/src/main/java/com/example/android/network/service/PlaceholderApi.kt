package com.example.android.network.service

import com.example.android.data.PlaceholderPhotos
import com.example.android.data.PlaceholderPosts
import com.example.android.data.PlaceholderUsers
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PlaceholderApi{

    @GET("/posts")
    fun getPosts() : Deferred<Response<List<PlaceholderPosts>>>

    @GET("/users")
    fun getUsers() : Deferred<Response<List<PlaceholderUsers>>>

    @GET("/photos")
    fun getPhotos() : Deferred<Response<List<PlaceholderPhotos>>>

}