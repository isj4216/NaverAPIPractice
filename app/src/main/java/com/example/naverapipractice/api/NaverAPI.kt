package com.example.naverapipractice.api

import com.example.naverapipractice.ResultTransferPapago
import com.example.naverapipractice.model.ResultGetSearchMovies
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface NaverAPI {
    //API 인터페이스 생성
    //GET방식으로 값을 받아오겠다는 것을 명시
    @GET("v1/search/movie.json")
    fun getSearchMovies(
//        @Header("X-Naver-Client-Id") clientId: String,
//        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null
        //Query는 실제로 함수 호출 시 필요한 파라미터로 값을 전달. null로 처리를 하면 입력 생략 가능.
    ): Call<ResultGetSearchMovies>

    //POST방식 어노테이션
    //POST방식은 @Field로 요청 변수를 입력.
    @FormUrlEncoded
    @POST("v1/papago/m2mt")
    fun transferPapago(
//        @Header("X-Naver-Client-Id") clientId: String,
//        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Field("source") source: String,
        @Field("target") target: String,
        @Field("text") text: String,
    ): Call<ResultTransferPapago>

    //전역처리
    //로그 기록에 사용할 HttpLoggingInterceptor와 고정 헤더값에 사용할 Interceptor를 만들어줍니다.
    //두개의 Interceptor를 클라이언트에 추가 후 다시 이 클라이언트를 Retrofit을 빌드할때 추가해줌.
    companion object {
//        영화
        private const val CLIENT_ID = "IRMdb2gClbu3g3IpK6MO"
        private const val CLIENT_SECRET = "pjRTdg2vAh"
        private const val BASE_URL_NAVER_API = "https://openapi.naver.com/"

//        파파고
//        private const val CLIENT_ID2 = "4aXXJF00o4TelIN3xxoI"
//        private const val CLIENT_SECRET2 = "Ugd5IpZ_5w"

        fun create(): NaverAPI {
            //로그기록 Interceptor
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            //고정 헤더값에 사용 할 Interceptor
            val headerInterceptor = Interceptor {
                val request = it.request().newBuilder()
                            .addHeader("X-Naver-Client-Id", CLIENT_ID)
                            .addHeader("X-Naver-Client-Secret", CLIENT_SECRET)
                            .build()

                return@Interceptor it.proceed(request)
            }

            val client = OkHttpClient.Builder()
                        .addInterceptor(headerInterceptor)
                        .addInterceptor(httpLoggingInterceptor)
                        .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL_NAVER_API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NaverAPI::class.java)
        }
    }
}