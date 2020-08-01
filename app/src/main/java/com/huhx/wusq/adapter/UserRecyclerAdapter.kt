package com.huhx.wusq.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.huhx.wusq.R
import com.huhx.wusq.common.Constant
import com.huhx.wusq.listener.OnItemClickListener
import com.huhx.wusq.domain.User
import com.squareup.picasso.Picasso

class UserRecyclerAdapter(private val users: List<User>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<UserRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userTextView: TextView = itemView.findViewById(R.id.tv_fullname)
        val userImageView: ImageView = itemView.findViewById(R.id.iv_user_image)
        val birthdayTextView: TextView = itemView.findViewById(R.id.user_birthday)
        val signatureTextView: TextView = itemView.findViewById(R.id.user_signature)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users[position]
        holder.userTextView.text = user.fullname
        holder.birthdayTextView.text = user.createTime
        holder.signatureTextView.text = user.signature
        Picasso.get().load(Constant.FILE_URL + user.imageUrl).into(holder.userImageView)

        holder.userImageView.setOnClickListener {
            Toast.makeText(it.context, "image click", Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener { listener.onItemClick(user) }
        holder.itemView.setOnLongClickListener() {
            listener.onItemLongClick(user)
            true
        }
    }
}