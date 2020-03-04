package com.jiacorp.androidexample3

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


interface ZocdocService {
    @GET("/api/2/professionallocation/ProfessionalDetails?professional_id=8676&specialty_id=153")
    fun getProfessional(): Single<Response<BaseZdApiResponse>>

    @GET("/api/1/reviews/doctor?locale=en&version=87&zdApp=AndroidApp&key=F31CA70B-CD50-4A01-A503-E4841C813D0E&id=361&per_page=10&page=0")
    fun getReviews(): Single<Response<ReviewResponse>>
}