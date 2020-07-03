package com.example.gamerecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamerecyclerview.models.BlogPost

//extend the generic recyclerview adapter class, inside pass a type, a generic type
class BlogRecAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<BlogPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return items.size
    }
}