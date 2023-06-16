package com.capstone.pathfinderapp.api

import com.capstone.pathfinderapp.model.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("users/login")
    fun loginAPI(
        @Field ("email") email: String,
        @Field ("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("users/register")
    fun registerUser(
        @Field ("email") email: String,
        @Field ("password") password: String,
        @Field ("role") name: String,
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @GET("students/id/{id}")
    fun getStudent(
        @Path ("id") id: String,
        @Field ("name") name: String,
        @Field ("email") email: String,
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @GET("lessons")
    fun getLessons(
        @Header("Authorization") token: String
    ): Call<LessonsResponse>

    @FormUrlEncoded
    @GET("lessons/id/{id}")
    fun getLesson(
        @Path ("id") id: String,
        @Header("Authorization") token: String
    ): Call<LessonResponse>


    @POST("predict_sentiment")
    fun predictSentiment(
        @Body requestBody: RequestBody
    ): Call<ResponseModel>

    @POST("predict_int")
    fun predictInt(
        @Body requestBody: RequestBody
    ): Call<predictIntResponse>

}