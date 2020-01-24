package com.huhx.wusq.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huhx.wusq.R
import com.huhx.wusq.domain.Fruit

class FruitAdapter(private val fruits: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (context == null) {
            context = parent.context
        }
        val view = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.textView.text = fruit.name
        Glide.with(context!!).load(fruit.imageId).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.fruit_image)
        var textView: TextView = view.findViewById(R.id.fruit_name)
    }

}