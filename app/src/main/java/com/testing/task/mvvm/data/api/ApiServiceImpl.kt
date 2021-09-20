package com.testing.task.mvvm.data.api

import android.content.Context
import com.testing.task.mvvm.utils.Const
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object  ApiServiceImpl {
    private var retrofit: Retrofit? = null
    private val REQUEST_TIMEOUT = 200
    private var okHttpClient: OkHttpClient? = null

    fun getClient(context: Context): Retrofit? {
        if (okHttpClient == null) initOkHttp(
            context
        )
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }


    private fun initOkHttp(context: Context) {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(
                REQUEST_TIMEOUT.toLong(),
                TimeUnit.SECONDS
            )
            .readTimeout(
                REQUEST_TIMEOUT.toLong(),
                TimeUnit.SECONDS
            )
            .writeTimeout(
                REQUEST_TIMEOUT.toLong(),
                TimeUnit.SECONDS
            )
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("cache-control", "no-cache")
                .addHeader("Content-Type", "text/plain")
                .addHeader("Content-Type", "multipart/formdata")
                .addHeader("Content-Type", "application/json")
            // .addHeader("Content-Type", "multipart/form-data");

            // Adding Authorization token (API Key)
            // Requests will be denied without API key
            /* if (!TextUtils.isEmpty(PrefUtils.getApiKey(context))) {
             requestBuilder.addHeader("Authorization", PrefUtils.getApiKey(context));
         }*/
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        okHttpClient = httpClient.build()
    }



}