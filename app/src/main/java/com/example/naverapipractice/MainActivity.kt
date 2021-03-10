package com.example.naverapipractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        /******************************************************
//         * API로 이동
//        val CLIENT_ID = "IRMdb2gClbu3g3IpK6MO"
//        val CLIENT_SECRET = "pjRTdg2vAh"
//        val BASE_URL_NAVER_API = "https://openapi.naver.com/"
//
//        val CLIENT_ID2 = "4aXXJF00o4TelIN3xxoI"
//        val CLIENT_SECRET2 = "Ugd5IpZ_5w"
//
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URLNAVER_API)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        ***********************************************************/
//
//        val api = retrofit.create(NaverAPI::class.java)
//        /*******************GET************************/
//        val callGetSearchMovies = api.getSearchMovies(CLIENT_ID, CLIENT_SECRET, "테스트")
//
//        //.enqueue로 동작. 비동기로 동작, 메인 UI쓰레드로 동작하려면 execute를 호출
//        callGetSearchMovies.enqueue(object : Callback<ResultGetSearchMovies>{
//            override fun onResponse(call: Call<ResultGetSearchMovies>, response: Response<ResultGetSearchMovies>) {
//                Log.d("결과GET", "성공 : ${response.raw()}")
//            }
//
//            override fun onFailure(call: Call<ResultGetSearchMovies>, t: Throwable) {
//                Log.d("결과GET", "실패 : ${t}")
//            }
//        })
//
//        /*******************POST************************/
//        val callPostTransferPapago = api.transferPapago(
//                CLIENT_ID2, CLIENT_SECRET2, "ko",
//                "en", "테스트입니다. 이거 번역해주세요.")
//
//        callPostTransferPapago.enqueue(object  : Callback<ResultTransferPapago>{
//            override fun onResponse(call: Call<ResultTransferPapago>, response: Response<ResultTransferPapago>) {
//                Log.d("결과POST", "성공 : ${response.raw()}")
//            }
//
//            override fun onFailure(call: Call<ResultTransferPapago>, t: Throwable) {
//                Log.d("결과POST", "실패 : ${t}")
//            }
//        })

//        val api = NaverAPI.create()
//
//        api.getSearchMovies("테스트").enqueue(object : Callback<ResultGetSearchMovies> {
//            override fun onResponse(call: Call<ResultGetSearchMovies>, response: Response<ResultGetSearchMovies>) {
//                //성공
//                Log.d("결과GET1", "성공 : ${response.raw()}")
//            }
//
//            override fun onFailure(call: Call<ResultGetSearchMovies>, t: Throwable) {
//                //실패
//                Log.d("결과GET1", "실패 : ${t}")
//            }
//        })

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}