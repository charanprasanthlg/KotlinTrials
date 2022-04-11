package com.example.kotlintrials.services

import com.example.kotlintrials.model.DataModelItem
import com.example.kotlintrials.model.RetrofitCrudModel
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @GET("todos/")
    fun getDataFromApi(): Call<List<DataModelItem>>

    @FormUrlEncoded
    @POST("posts/")
    fun createUser(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") body: String,
    ): Call<RetrofitCrudModel>

    @FormUrlEncoded
    @PUT("posts/{id}/")
    fun updateUser(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") body: String,
        @Path("id") id: Int,
    ): Call<RetrofitCrudModel>

    @DELETE("posts/{id}/")
    fun deleteUser(
        @Path("id") id: Int,
    ): Call<Unit>
}