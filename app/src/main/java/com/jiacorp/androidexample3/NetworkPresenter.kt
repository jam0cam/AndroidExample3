package com.jiacorp.androidexample3

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkPresenter {

    val service: ZocdocService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.zocdoc.com/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        service = retrofit.create(ZocdocService::class.java)
    }

    fun providerCall() {
        service.getProfessional()
            .withSchedulers()
            .subscribe({
                Log.e("JIA", "provider call success")
            },{
                Log.e("JIA", "provider call ERROR $it")
            })
    }

    fun reviewsCall() {
        service.getReviews()
            .withSchedulers()
            .subscribe({
                Log.e("JIA", "reviewsCall success")
            },{
                Log.e("JIA", "reviewsCall ERROR $it")
            })

    }



}