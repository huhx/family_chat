package com.huhx.wusq.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.huhx.wusq.R
import com.huhx.wusq.listener.OnItemClickListener
import com.huhx.wusq.domain.User

class UserRecyclerAdapter(private val users: List<User>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<UserRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userTextView: TextView = itemView.findViewById(R.id.username)
        val phoneTextView: TextView = itemView.findViewById(R.id.phone)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (username, phone) = users[position]
        holder.userTextView.text = username
        holder.phoneTextView.text = phone
        holder.itemView.setOnClickListener { listener.onItemClick(users[position]) }
        holder.itemView.setOnLongClickListener() {
            listener.onItemLongClick(users[position])
            true
        }
    }
}