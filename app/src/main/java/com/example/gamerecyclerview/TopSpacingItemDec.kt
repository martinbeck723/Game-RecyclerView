package com.example.gamerecyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
//create this class to get the padding right
class TopSpacingItemDec(private val padding:Int):RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top=padding
    }
}