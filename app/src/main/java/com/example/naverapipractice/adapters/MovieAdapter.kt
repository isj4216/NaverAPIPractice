package com.example.naverapipractice.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.naverapipractice.Items
import com.example.naverapipractice.R
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(val context: Context, val movieList: List<Items>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun getItemCount(): Int {
        //아이템개수 리턴
        return movieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        //아이템을 넣는 틀
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //틀과 넘어온 내용을 합쳐줌(View에 내용을 입력)
        //list = 1, 2, 3...
        val movieList = movieList[position]

//        holder.movieImage.drawable
        holder.movieTitle.text = movieList.title
    }

    inner class MovieViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        //item_movie.xml에 연결

        fun bindItems(data : Items){
            Glide.with(view.context).load(data.image)
            .apply(RequestOptions().override(300,450))
            .apply(RequestOptions.centerCropTransform())
            .into(view.movieImage)

            itemView.movieTitle.text = data.title

            //클릭시 웹사이트 연결
            itemView.setOnClickListener {
                val wepPage = Uri.parse("${data.link}")
                val webIntent = Intent(Intent.ACTION_VIEW, wepPage)
                view.getContext().startActivity(webIntent)
            }
        }





        val movieImage = view.movieImage
        val movieTitle = view.movieTitle
        val root = view.root
    }
}