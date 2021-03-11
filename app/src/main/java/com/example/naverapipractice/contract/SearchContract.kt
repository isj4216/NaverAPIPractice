package com.example.naverapipractice.contract

import com.example.naverapipractice.Items

interface SearchContract {
    //view와 Presenter가 구현해야할 인터페이스를 정의하는 Contract
    interface view{
        fun showMovieList(movieList : List<Items>)
    }

    interface presenter{

    }
}