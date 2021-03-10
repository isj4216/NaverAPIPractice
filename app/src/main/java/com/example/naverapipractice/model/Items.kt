package com.example.naverapipractice

data class ListItems (val items : List<Items>)
//파싱할 값을 저장할 데이터 클래스
data class Items(
    val title : String,
    val link : String,
    val image : String,
    val subtitle : String,
    val pubDate : String,
    val director : String,
    val actor : String,
    val usrRating : String
)
