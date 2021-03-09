package com.example.naverapipractice

//파싱할 값을 저장할 데이터 클래스
data class ResultGetSearchMovies (
    //data Class
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<Items>
)