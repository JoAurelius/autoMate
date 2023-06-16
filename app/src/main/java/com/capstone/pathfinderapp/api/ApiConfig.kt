package com.capstone.pathfinderapp.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            val authInterceptor = Interceptor { chain ->
                val req = chain.request()
                val requestHeaders = req.newBuilder()
                    .addHeader("Authorization", "eyJhbGciOiJSUzI1NiIsImtpZCI6IjY3YmFiYWFiYTEwNWFkZDZiM2ZiYjlmZjNmZjVmZTNkY2E0Y2VkYTEiLCJ0eXAiOiJKV1QifQ.eyJyb2xlIjoiZG9zZW4iLCJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vY2FtcHVzLTgxOGYxIiwiYXVkIjoiY2FtcHVzLTgxOGYxIiwiYXV0aF90aW1lIjoxNjg2ODIzMzIxLCJ1c2VyX2lkIjoiTnppVzBwRHNSYmZsTVZMYW9GSFdKU2VxM0sxMiIsInN1YiI6Ik56aVcwcERzUmJmbE1WTGFvRkhXSlNlcTNLMTIiLCJpYXQiOjE2ODY4MjMzMjEsImV4cCI6MTY4NjgyNjkyMSwiZW1haWwiOiIxMjM0QGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJlbWFpbCI6WyIxMjM0QGdtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6ImN1c3RvbSJ9fQ.fMcFMF7fK3B_whwqB9oOI5EOG3kzCXBJKHld87L901lqqnRa45Kff-hNEZxRcwt8e6fCVLRkv7W3zsEmQgPcwaJAEaWEK9oTx4BtQkScrPlTkf73fXfJwNnZayHx6Mtckcw8eFAZeguaR7a7oCJqOdtvQFXv_6w3Cl6WQA6vuejuEUSMMpQla8bxkxWQRu7ZoXipG4wgp3E4wLlT5zM_2NyDOeGE3yhkUvkmSvZ6ZC5d8SdqC4lxNhIjZhZzPAPL4hoZmOlhWuIS94rMdM4ZhVEcX8udyZ-8Ov6plJo4e63kEHihWZCiujpODtjQvqy10by4J-WQglAN268Fwb6C2w")
                    .build()
                chain.proceed(requestHeaders)
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build()
            val apiReterofit =  Retrofit.Builder()
                .baseUrl("https://production-ox2aw5bkbq-et.a.run.app")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return apiReterofit.create(ApiService::class.java)
        }
    }
}