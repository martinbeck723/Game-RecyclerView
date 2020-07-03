package com.example.gamerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogRecAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecView()
        addDataSet()
    }


    private fun addDataSet(){
        val data=DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    //set up recyclerView after adding recyclerView in activity main xml

    private fun initRecView(){
        //normal method
//        recycler_view.layoutManager=LinearLayoutManager(this@MainActivity)
//        blogAdapter= BlogRecAdapter()
//        recycler_view.adapter=blogAdapter

        //apply is easier, no need to write id anymore
        recycler_view.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            blogAdapter= BlogRecAdapter()
            adapter=blogAdapter
            val topSpacingDecoration=TopSpacingItemDec(30)
            addItemDecoration(topSpacingDecoration)
        }
    }
}
