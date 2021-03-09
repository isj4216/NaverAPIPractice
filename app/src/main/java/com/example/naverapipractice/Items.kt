package com.example.naverapipractice

//파싱할 값을 저장할 데이터 클래스
data class Items(
    var title: String = "",
    var originallink: String = "",
    var link: String = "",
    var description: String = "",
    var pubDate: String = ""
)
