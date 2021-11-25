package com.example.healthkiosk.api

import com.example.healthkiosk.model.SignInBody
import com.example.healthkiosk.model.UserBody
import com.example.healthkiosk.model.defaultResponse
import com.example.healthkiosk.model.loginResponse
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type:application/json")
    @POST("login")
    fun signIn(@Body info: SignInBody
    ): retrofit2.Call<loginResponse>

//    @Headers("Content-Type:application/json")
//    @POST("register")
//    fun registerUser(
//        @Body info: UserBody
//    ): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("register")
    fun registerUser(
        @Body info: UserBody
    ): retrofit2.Call<defaultResponse>


}