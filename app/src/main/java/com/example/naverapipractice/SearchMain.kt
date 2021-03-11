package com.example.naverapipractice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naverapipractice.adapters.MovieAdapter
import com.example.naverapipractice.api.NaverAPI
import com.example.naverapipractice.model.ResultGetSearchMovies
import kotlinx.android.synthetic.main.search_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchMain: AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_main)

        searchButton.setOnClickListener {
            //searchButton 클릭이벤트 발생시
            val editText : String? = searchEditText.text.toString()
//            Toast.makeText(applicationContext, editText.text.toString().trim(), Toast.LENGTH_SHORT).show()

            if (editText != null) {
                if(editText.trim() == ""){//trim() 공백 삭제
                    //값이 없을경우
                    Toast.makeText(applicationContext, "검색어를 입력해주세요", Toast.LENGTH_SHORT).show()
                    searchEditText.setText("")
                }else{
                    //널이 아닌 경우
                    //레이아웃 매니저 설정
                    movieRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                    //항목의 높이나 너비가 변경되지 안으며, 추가 또는 제거된 모든 항목은 동일하다.
                    movieRecyclerView.setHasFixedSize(true)

                    //API
                    fetchJson(searchEditText.text.toString())

                    //키보드를 내린다.
                    val out = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    out.hideSoftInputFromWindow(searchEditText.windowToken, 0)

                    Toast.makeText(applicationContext, "검색이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun fetchJson(vararg p0 : String){
        //vararg 가변인자 : 함수 호출 시, 인자 개수를 유동적으로 지정 가능
        val api = NaverAPI.create()
        val query : String = searchEditText.text.toString()

        //                              1~10개 까지만
        //enqueue를 통해서 onResponse와 onFailure를 사용
        api.getSearchMovies(query, 10, 1).enqueue(object : Callback<ResultGetSearchMovies> {
            override fun onResponse(call: Call<ResultGetSearchMovies>, response: Response<ResultGetSearchMovies>) {
                //성공
                //onResponse의 경우 서버에서 정의하는 success가 아닌 경우에 대한 예외 처리를 포함 한 코드를 작성해야한다.
                Log.d("결과GET", "성공 : ${response.raw()}")

                val body : List<Items>? = response?.body()?.items
                println("Success to excute request : ${body}")
//
//                //Gson을 Kotlin에서 사용 가능한 object로 만든다.
//                val gson = GsonBuilder().create()
//                println("aa1" + gson)
//                val listItems = gson.fromJson(body, Items::class.java)
//                println("aa2" + listItems)

                //현재 스레드가 UI스레드라면 UI자원을 사용하는 행동에 대해서는 즉시 실행.
                //현재 스레드가 UI스레드가 아니라면 행동은 UI스레드의 자원 사용 이벤트 큐에 들어간다.
                runOnUiThread {
                    movieRecyclerView.adapter = MovieAdapter(this@SearchMain, body)
                    searchEditText.setText("")
                }
            }

            override fun onFailure(call: Call<ResultGetSearchMovies>, t: Throwable) {
                //실패
                Log.d("결과GET", "실패 : ${t}")
            }
        })
    }
}