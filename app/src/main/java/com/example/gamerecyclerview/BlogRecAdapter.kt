package com.example.gamerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gamerecyclerview.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

//extend the generic recyclerview adapter class, inside pass a type, a generic type
class BlogRecAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<BlogPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            //this line will be same every time
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    //need this method to submit data
    fun submitList(blogList:List<BlogPost>){
        items=blogList
    }
    //build a custom viewholder class, take the data set it to viewholder, describe what view look likes
    class BlogViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        //get the item from xml by id
        val blogImage=itemView.blog_image
        val blogTitle=itemView.blog_title
        val blogAuthor=itemView.blog_author

        //take each blogpost object and bind to layout, bind the above 3 items
        fun bind(blogPost: BlogPost){
            blogTitle.setText(blogPost.title)
            blogAuthor.setText(blogPost.username)

            //use glide to get the image
                //set the default if the image loading has error or issues
                val requestOptions=RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)
        }
    }
}