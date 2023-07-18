package com.hsmnzaydn.other_applications

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

internal class DataSource {
    companion object{
        fun retrofitProvider():Retrofit{
            val baseUrl = "https://havucapps.com/"

            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    interface ApplicationService {
        @GET("api/other-applications")
        suspend fun otherApplications(): OtherApplicationResponse
    }
}